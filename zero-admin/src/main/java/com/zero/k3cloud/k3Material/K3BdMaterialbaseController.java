package com.zero.k3cloud.k3Material;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.SecurityUtils;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialcategory;
import com.zero.system.k3cloud.k3Material.service.IK3BdMaterialcategoryService;
import com.zero.system.k3cloud.k3Organization.domain.K3Organization;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StopWatch;
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
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialbase;
import com.zero.system.k3cloud.k3Material.service.IK3BdMaterialbaseService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;



/**
 * 存储物料信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@RestController
@RequestMapping("/system/k3cloud/k3BdMaterialbase")
public class K3BdMaterialbaseController extends BaseController
{
    @Autowired
    private IK3BdMaterialbaseService k3BdMaterialbaseService;

    @Autowired
    private IK3BdMaterialcategoryService k3BdMaterialcategoryService;

    @Autowired
    private IK3OrganizationService k3OrganizationService;

    /**
     * 查询存储物料信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:list')")
    @GetMapping("/list")
    public TableDataInfo list(K3BdMaterialbase k3BdMaterialbase)
    {
        startPage();
        List<K3BdMaterialbase> list = k3BdMaterialbaseService.selectK3BdMaterialbaseList(k3BdMaterialbase);
        return getDataTable(list);
    }

    /**
     * 导出存储物料信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:export')")
    @Log(title = "存储物料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, K3BdMaterialbase k3BdMaterialbase)
    {
        List<K3BdMaterialbase> list = k3BdMaterialbaseService.selectK3BdMaterialbaseList(k3BdMaterialbase);
        ExcelUtil<K3BdMaterialbase> util = new ExcelUtil<K3BdMaterialbase>(K3BdMaterialbase.class);
        util.exportExcel(response, list, "存储物料信息数据");
    }

    /**
     * 获取存储物料信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(k3BdMaterialbaseService.selectK3BdMaterialbaseById(id));
    }

    /**
     * 新增存储物料信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:add')")
    @Log(title = "存储物料信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody K3BdMaterialbase k3BdMaterialbase)
    {
        return toAjax(k3BdMaterialbaseService.insertK3BdMaterialbase(k3BdMaterialbase));
    }

    /**
     * 修改存储物料信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:edit')")
    @Log(title = "存储物料信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody K3BdMaterialbase k3BdMaterialbase)
    {
        return toAjax(k3BdMaterialbaseService.updateK3BdMaterialbase(k3BdMaterialbase));
    }

    /**
     * 删除存储物料信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:remove')")
    @Log(title = "存储物料信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(k3BdMaterialbaseService.deleteK3BdMaterialbaseByIds(ids));
    }

    /**
     * 从k3物料接口抓取组织数据 BD_MATERIAL 格式如下
     * 物料内码，物料编码，物料名称，存货类别内码，创建组织，使用组织，禁用状态
     * {
     *     "FormId": "BD_MATERIAL",
     *     "FieldKeys": "FMATERIALID,FNUMBER,FNAME,FCATEGORYID,FCREATEORGID,FUSEORGID,FFORBIDSTATUS",
     *     "FilterString": "",
     *     "OrderString": "",
     *     "TopRowCount": 0,
     *     "StartRow": 0,
     *     "Limit": 2
     * }
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('system:k3BdMaterialbase:webapi')")
    @Log(title = "调用物料接口", businessType = BusinessType.WEBAPI_SELECT)
    @PostMapping("/k3WebApiAcquire")
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult k3WebApiAcquire() throws Exception{
        try{
            //调用k3接口
            K3CloudApi api = new K3CloudApi();
            //定义组织接口调用格式
            String sContent = "{\n" +
                    "    \"FormId\": \"BD_MATERIAL\",\n" +
                    "    \"FieldKeys\": \"FMATERIALID,FNUMBER,FNAME,FCATEGORYID,FCREATEORGID,FUSEORGID,FFORBIDSTATUS\",\n" +
                    "    \"FilterString\": \"\",\n" +
                    "    \"OrderString\": \"\",\n" +
                    "    \"TopRowCount\": 0,\n" +
                    "    \"StartRow\": 0,\n" +
                    "    \"Limit\": 0\n" +
                    "}";
            //接口调用标识
            String sFormId = "BD_MATERIAL";
            //构成list
            List<List<Object>> list = api.executeBillQuery(sContent);
            //定义一个新的集合
            List<K3BdMaterialbase> k3BdMaterialbaseList = new ArrayList<>();
            //循环遍历多维数组,定义字段信息
            if (list.size() > 0){
                for (int i = 0; i < list.size(); i++){
                    //初始化实体类，需要放到for循环中去
                    K3BdMaterialbase k3BdMaterialbase = new K3BdMaterialbase();
                    //物料内码
                    k3BdMaterialbase.setFmaterialId((Long) list.get(i).get(0));
                    //物料编号
                    k3BdMaterialbase.setFnumber((String) list.get(i).get(1));
                    //物料名称
                    k3BdMaterialbase.setFname((String) list.get(i).get(2));
                    //存货类别ID
                    k3BdMaterialbase.setFcategoryId((Long) list.get(i).get(3));
                    //创建组织ID
                    k3BdMaterialbase.setFcreateorgId((Long) list.get(i).get(4));
                    //使用组织ID
                    k3BdMaterialbase.setFuseorgId((Long) list.get(i).get(5));
                    //禁用状态
                    k3BdMaterialbase.setFforbidStatus((String) list.get(i).get(6));
                    //构建新的集合
                    k3BdMaterialbaseList.add(k3BdMaterialbase);
                }
            }else {
                return error("未从接口中获取数据，请检查接口");
            }
            //将数据进行存储
            //初始化
            K3BdMaterialbase k3BdMaterialbase = new K3BdMaterialbase();
            //检查历史数据
            List<K3BdMaterialbase> listM = k3BdMaterialbaseService.selectK3BdMaterialbaseList(k3BdMaterialbase);
            if (k3BdMaterialbaseList.size() > listM.size() ){
                System.out.println("数据条数" + k3BdMaterialbaseList.size());
                //删除原有记录
                k3BdMaterialbaseService.deleteK3BdMaterialbaseAll();
                //执行数据插入
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();

                List<K3BdMaterialbase> k3Mbs = new ArrayList<>();
                int countNum = 0;//总数
                for (int i = 0; i < k3BdMaterialbaseList.size(); i++){
                    K3BdMaterialbase k3BdMb = new K3BdMaterialbase();
                    K3BdMaterialbase k3Mb = k3BdMaterialbaseList.get(i);
                    //物料内码
                    k3BdMb.setFmaterialId(k3Mb.getFmaterialId());
                    //物料编号
                    k3BdMb.setFnumber(k3Mb.getFnumber());
                    //物料名称
                    k3BdMb.setFname(k3Mb.getFname());
                    //存货类别ID
                    k3BdMb.setFcategoryId(k3Mb.getFcategoryId());
                    //获取存货类别名称
                    K3BdMaterialcategory k3BdMaterialcategory = k3BdMaterialcategoryService.selectK3BdMaterialcategoryByCgId(k3Mb.getFcategoryId());
                    k3BdMb.setFcategoryName(k3BdMaterialcategory.getFname());
                    //创建组织ID
                    k3BdMb.setFcreateorgId(k3Mb.getFcreateorgId());
                    //创建组织名称
                    K3Organization k3Organization = k3OrganizationService.selectK3OrganizationByForgid(k3Mb.getFcreateorgId());
                    k3BdMb.setFcreateorgName(k3Organization.getFname());
                    //使用组织ID
                    k3BdMb.setFuseorgId(k3Mb.getFuseorgId());
                    //创建组织名称
                    K3Organization k3Organization_ = k3OrganizationService.selectK3OrganizationByForgid(k3Mb.getFuseorgId());
                    k3BdMb.setFuseorgName(k3Organization_.getFname());
                    //禁用状态
                    k3BdMb.setFforbidStatus(k3Mb.getFforbidStatus());
                    //创建人
                    k3BdMb.setCreateBy(SecurityUtils.getUsername());
                    //创建时间
                    k3BdMb.setCreateTime(DateUtils.getNowDate());
                    //构成新的数组
                    k3Mbs.add(k3BdMb);
                }
                System.out.println(k3Mbs.size());
                //调用批量插入
                k3BdMaterialbaseService.saveBeach(k3Mbs);
                stopWatch.stop();
                System.out.println("使用sqlSessionFactory实现批量插入：" + stopWatch.getTotalTimeMillis() + "毫秒");
                return success("操作完成");
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return error("数据抓取失败，报错如下" + e.getMessage());
        }
        return success("数据执行成功");
    }

}
