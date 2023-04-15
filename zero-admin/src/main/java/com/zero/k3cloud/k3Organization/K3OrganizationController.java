package com.zero.k3cloud.k3Organization;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.zero.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zero.common.annotation.Log;
import com.zero.common.core.controller.BaseController;
import com.zero.common.core.domain.AjaxResult;
import com.zero.common.enums.BusinessType;
import com.zero.system.k3cloud.k3Organization.domain.K3Organization;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 存储第三方组织信息Controller
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
@RestController
@RequestMapping("/system/k3cloud/k3Organization")
public class K3OrganizationController extends BaseController
{
    @Autowired
    private IK3OrganizationService k3OrganizationService;

    /**
     * 查询存储第三方组织信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:list')")
    @GetMapping("/list")
    public TableDataInfo list(K3Organization k3Organization)
    {
        startPage();
        List<K3Organization> list = k3OrganizationService.selectK3OrganizationList(k3Organization);
        return getDataTable(list);
    }

    /**
     * 导出存储第三方组织信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:export')")
    @Log(title = "存储第三方组织信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, K3Organization k3Organization)
    {
        List<K3Organization> list = k3OrganizationService.selectK3OrganizationList(k3Organization);
        ExcelUtil<K3Organization> util = new ExcelUtil<K3Organization>(K3Organization.class);
        util.exportExcel(response, list, "存储第三方组织信息数据");
    }

    /**
     * 获取存储第三方组织信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(k3OrganizationService.selectK3OrganizationById(id));
    }

    /**
     * 新增存储第三方组织信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:add')")
    @Log(title = "存储第三方组织信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody K3Organization k3Organization)
    {
        return toAjax(k3OrganizationService.insertK3Organization(k3Organization));
    }

    /**
     * 修改存储第三方组织信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:edit')")
    @Log(title = "存储第三方组织信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody K3Organization k3Organization)
    {
        return toAjax(k3OrganizationService.updateK3Organization(k3Organization));
    }

    /**
     * 删除存储第三方组织信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:remove')")
    @Log(title = "存储第三方组织信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(k3OrganizationService.deleteK3OrganizationByIds(ids));
    }


    /**
     * 从k3组织接口抓取组织数据
     * ORG_Organizations
     * 抓取格式如下组织编号、组织名称、禁用状态，
     *       {
     *         "FormId": "ORG_Organizations",
     *         "FieldKeys": "FNUMBER,FNAME,FFORBIDSTATUS",  //字段信息
     *         "FilterString": "", //查询条件，参考sql
     *         "OrderString": "",
     *         "TopRowCount": 0,
     *         "StartRow": 0,
     *         "Limit": 0  //分页条数 0默认全部
     *         }
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:k3Organization:webapi')")
    @Log(title = "组织接口获取至本地", businessType = BusinessType.WEBAPI_SELECT)
    @PostMapping("/k3WebApiOrganizationAcquire")
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult k3WebApiOrganizationAcquire() throws Exception {

        try{
            //调用k3接口
            K3CloudApi api = new K3CloudApi();
            //定义组织接口调用格式
            String sContent = "{\n" +
                    "    \"FormId\": \"ORG_Organizations\",\n" +
                    "    \"FieldKeys\": \"FORGID,FNUMBER,FNAME,FFORBIDSTATUS\",\n" +
                    "    \"FilterString\": \"\",\n" +
                    "    \"OrderString\": \"\",\n" +
                    "    \"TopRowCount\": 0,\n" +
                    "    \"StartRow\": 0,\n" +
                    "    \"Limit\": 0\n" +
                    "}";
            //接口调用标识
            String sFormId = "ORG_Organizations";
            //构成list
            List<List<Object>> list = api.executeBillQuery(sContent);
            //定义一个新的集合
            List<K3Organization> k3OrganizationList = new ArrayList<>();
            //循环遍历多维数组,定义字段信息
            if (list.size() > 0){
                for (int i = 0; i < list.size(); i++){
                    //初始化实体类，需要放到for循环中去
                    K3Organization k3Organization = new K3Organization();
                    //组织内码
                    k3Organization.setForgid((Long) list.get(i).get(0));
                    //组织编号
                    k3Organization.setFnumber((String) list.get(i).get(1));
                    //组织名称
                    k3Organization.setFname((String) list.get(i).get(2));
                    //组织禁用状态
                    k3Organization.setFforbidStatus((String) list.get(i).get(3));
                    k3OrganizationList.add(k3Organization);
                }
            }else {
                return error("未从接口中获取数据，请检查接口");
            }
            //将数据进行存储
            //初始化
            K3Organization k3Organization = new K3Organization();
            //检查历史数据
            List<K3Organization> listPr = k3OrganizationService.selectK3OrganizationList(k3Organization);
            if (k3OrganizationList.size() > listPr.size() ){
                //清楚原有记录
                k3OrganizationService.deleteK3OrganizationAll();
                for (int i = 0; i < k3OrganizationList.size(); i++){
                    //组织内码
                    k3Organization.setForgid(k3OrganizationList.get(i).getForgid());
                    //组织编号
                    k3Organization.setFnumber(k3OrganizationList.get(i).getFnumber());
                    //组织名称
                    k3Organization.setFname(k3OrganizationList.get(i).getFname());
                    //组织禁用状态
                    k3Organization.setFforbidStatus(k3OrganizationList.get(i).getFforbidStatus());
                    //创建人
                    k3Organization.setCreateBy(SecurityUtils.getUsername());
                    k3OrganizationService.insertK3Organization(k3Organization);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return error("数据抓取失败，报错如下" + e.getMessage());
        }
        return success("数据执行成功");
    }
}
