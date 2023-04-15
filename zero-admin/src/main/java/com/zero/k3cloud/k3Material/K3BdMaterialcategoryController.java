package com.zero.k3cloud.k3Material;

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
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialcategory;
import com.zero.system.k3cloud.k3Material.service.IK3BdMaterialcategoryService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 存储第三方物料类别信息Controller
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
@RestController
@RequestMapping("/system/k3cloud/k3BdMaterialcategory")
public class K3BdMaterialcategoryController extends BaseController
{
    @Autowired
    private IK3BdMaterialcategoryService k3BdMaterialcategoryService;

    /**
     * 查询存储第三方物料类别信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:list')")
    @GetMapping("/list")
    public TableDataInfo list(K3BdMaterialcategory k3BdMaterialcategory)
    {
        startPage();
        List<K3BdMaterialcategory> list = k3BdMaterialcategoryService.selectK3BdMaterialcategoryList(k3BdMaterialcategory);
        return getDataTable(list);
    }

    /**
     * 导出存储第三方物料类别信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:export')")
    @Log(title = "存储第三方物料类别信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, K3BdMaterialcategory k3BdMaterialcategory)
    {
        List<K3BdMaterialcategory> list = k3BdMaterialcategoryService.selectK3BdMaterialcategoryList(k3BdMaterialcategory);
        ExcelUtil<K3BdMaterialcategory> util = new ExcelUtil<K3BdMaterialcategory>(K3BdMaterialcategory.class);
        util.exportExcel(response, list, "存储第三方物料类别信息数据");
    }

    /**
     * 获取存储第三方物料类别信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(k3BdMaterialcategoryService.selectK3BdMaterialcategoryById(id));
    }

    /**
     * 新增存储第三方物料类别信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:add')")
    @Log(title = "存储第三方物料类别信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody K3BdMaterialcategory k3BdMaterialcategory)
    {
        return toAjax(k3BdMaterialcategoryService.insertK3BdMaterialcategory(k3BdMaterialcategory));
    }

    /**
     *
     * 修改存储第三方物料类别信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:edit')")
    @Log(title = "存储第三方物料类别信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody K3BdMaterialcategory k3BdMaterialcategory)
    {
        return toAjax(k3BdMaterialcategoryService.updateK3BdMaterialcategory(k3BdMaterialcategory));
    }

    /**
     * 删除存储第三方物料类别信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:remove')")
    @Log(title = "存储第三方物料类别信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(k3BdMaterialcategoryService.deleteK3BdMaterialcategoryByIds(ids));
    }

    /**
     *
     * 从k3物料类别接口抓取组织数据 BD_MATERIALCATEGORY 格式如下
     * 物料类别内码 编码 名称 禁用状态
     * {
     *     "FormId": "BD_MATERIALCATEGORY",
     *     "FieldKeys": "FCATEGORYID,FNUMBER,FNAME",
     *     "FilterString": "",
     *     "OrderString": "",
     *     "TopRowCount": 0,
     *     "StartRow": 0,
     *     "Limit": 0
     * }
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialcategory:webapi')")
    @Log(title = "调用物料类别接口", businessType = BusinessType.WEBAPI_SELECT)
    @PostMapping("/k3WebApiAcquire")
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult k3WebApiAcquire() throws Exception {
        try{
            //调用k3接口
            K3CloudApi api = new K3CloudApi();
            //定义组织接口调用格式
            String sContent = "{\n" +
                    "    \"FormId\": \"BD_MATERIALCATEGORY\",\n" +
                    "    \"FieldKeys\": \"FCATEGORYID,FNUMBER,FNAME,FFORBIDSTATUS\",\n" +
                    "    \"FilterString\": \"\",\n" +
                    "    \"OrderString\": \"\",\n" +
                    "    \"TopRowCount\": 0,\n" +
                    "    \"StartRow\": 0,\n" +
                    "    \"Limit\": 0\n" +
                    "}";
            //接口调用标识
            String sFormId = "BD_MATERIALCATEGORY";
            //构成list
            List<List<Object>> list = api.executeBillQuery(sContent);
            //定义一个新的集合
            List<K3BdMaterialcategory> k3BdMaterialcategoryArrayList = new ArrayList<>();
            //循环遍历多维数组,定义字段信息
            if (list.size() > 0){
                for (int i = 0; i < list.size(); i++){
                    //初始化实体类，需要放到for循环中去
                    K3BdMaterialcategory k3BdMaterialcategory = new K3BdMaterialcategory();
                    //物料类别内码
                    k3BdMaterialcategory.setFcateGoryid((Long) list.get(i).get(0));
                    //编号
                    k3BdMaterialcategory.setFnumber((String) list.get(i).get(1));
                    //名称
                    k3BdMaterialcategory.setFname((String) list.get(i).get(2));
                    //禁用状态
                    k3BdMaterialcategory.setFforbidStatus((String) list.get(i).get(3));
                    k3BdMaterialcategoryArrayList.add(k3BdMaterialcategory);
                }
            }else {
                return error("未从接口中获取数据，请检查接口");
            }
            //将数据进行存储
            //初始化
            K3BdMaterialcategory k3BdMaterialcategory = new K3BdMaterialcategory();
            //检查历史数据
            List<K3BdMaterialcategory> listM = k3BdMaterialcategoryService.selectK3BdMaterialcategoryList(k3BdMaterialcategory);
            if (k3BdMaterialcategoryArrayList.size() > listM.size() ){
                //清楚原有记录
                k3BdMaterialcategoryService.deleteK3BdMaterialcategoryAll();
                for (int i = 0; i < k3BdMaterialcategoryArrayList.size(); i++){
                    //物料类别内码
                    k3BdMaterialcategory.setFcateGoryid(k3BdMaterialcategoryArrayList.get(i).getFcateGoryid());
                    //编号
                    k3BdMaterialcategory.setFnumber(k3BdMaterialcategoryArrayList.get(i).getFnumber());
                    //名称
                    k3BdMaterialcategory.setFname(k3BdMaterialcategoryArrayList.get(i).getFname());
                    //禁用状态
                    k3BdMaterialcategory.setFforbidStatus(k3BdMaterialcategoryArrayList.get(i).getFforbidStatus());
                    //创建人
                    k3BdMaterialcategory.setCreateBy(SecurityUtils.getUsername());
                    k3BdMaterialcategoryService.insertK3BdMaterialcategory(k3BdMaterialcategory);
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
