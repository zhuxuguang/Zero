package com.zero.k3cloud.k3Material;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kingdee.bos.webapi.sdk.K3CloudApi;
import com.zero.common.utils.CommonConstants;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.SecurityUtils;
import com.zero.system.domain.SysSpecialConfig;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialcategory;
import com.zero.system.k3cloud.k3Organization.domain.K3Organization;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationService;
import com.zero.system.service.ISysSpecialConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
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
import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;
import com.zero.system.k3cloud.k3Material.service.IK3SpPickmtrlService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 第三方简单生产领料单Controller
 * system/k3cloud/k3SpPickMtrl/index
 * @author zhuxuguang
 * @date 2023-04-03
 */
@Api("第三方单据信息")
@RestController
@RequestMapping("/system/k3cloud/k3SpPickmtrl")
public class K3SpPickmtrlController extends BaseController
{
    @Autowired
    private IK3SpPickmtrlService k3SpPickmtrlService;

    @Autowired
    private IK3OrganizationService k3OrganizationService;

    //专项参数信息
    @Autowired
    private ISysSpecialConfigService sysSpecialConfigService;

    /**
     * 查询第三方简单生产领料单列表
     */
    @ApiOperation("获取单据列表")
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:list')")
    @GetMapping("/list")
    public TableDataInfo list(K3SpPickmtrl k3SpPickmtrl)
    {
        startPage();
        List<K3SpPickmtrl> list = k3SpPickmtrlService.selectK3SpPickmtrlList(k3SpPickmtrl);
        return getDataTable(list);
    }

    /**
     * 导出第三方简单生产领料单列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:export')")
    @Log(title = "第三方简单生产领料单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, K3SpPickmtrl k3SpPickmtrl)
    {
        List<K3SpPickmtrl> list = k3SpPickmtrlService.selectK3SpPickmtrlList(k3SpPickmtrl);
        ExcelUtil<K3SpPickmtrl> util = new ExcelUtil<K3SpPickmtrl>(K3SpPickmtrl.class);
        util.exportExcel(response, list, "第三方简单生产领料单数据");
    }

    /**
     * 获取第三方简单生产领料单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(k3SpPickmtrlService.selectK3SpPickmtrlById(id));
    }

    /**
     * 新增第三方简单生产领料单
     */
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:add')")
    @Log(title = "第三方简单生产领料单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody K3SpPickmtrl k3SpPickmtrl)
    {
        return toAjax(k3SpPickmtrlService.insertK3SpPickmtrl(k3SpPickmtrl));
    }

    /**
     * 修改第三方简单生产领料单
     */
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:edit')")
    @Log(title = "第三方简单生产领料单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody K3SpPickmtrl k3SpPickmtrl)
    {
        return toAjax(k3SpPickmtrlService.updateK3SpPickmtrl(k3SpPickmtrl));
    }

    /**
     * 删除第三方简单生产领料单
     */
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:remove')")
    @Log(title = "第三方简单生产领料单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(k3SpPickmtrlService.deleteK3SpPickmtrlByIds(ids));
    }

    /**
     * 从k3接口抓取物料领用单据 SP_PickMtrl 格式如下
     * 源单ID，单据编号，业务日期，单据状态，发料组织ID，物料编码，物料名称，跨组织业务类型，规格，单位，实发数量，栋舍，仓库，成本
     * {
     *     "FormId": "SP_PickMtrl",
     *     "FieldKeys": "FID,FBILLNO,FDATE,FDOCUMENTSTATUS,FSTOCKORGID,FMATERIALID,FmaterialName,FTRANSFERBIZTYPEID,FSpecification,FUNITID,FACTUALQTY,FDS,FSTOCKID,FAMOUNT",
     *     "FilterString": "",
     *     "OrderString": "",
     *     "TopRowCount": 0,
     *     "StartRow": 0,
     *     "Limit": 10
     * }
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('system:k3SpPickmtrl:webapi')")
    @Log(title = "调用物料领用单据接口", businessType = BusinessType.WEBAPI_SELECT)
    @PostMapping("/k3WebApiAcquire")
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult k3WebApiAcquire() throws Exception{

        try{
            //调用k3接口
            K3CloudApi api = new K3CloudApi();
            //检查系统初始化时间
            SysSpecialConfig sysSpecialConfig = sysSpecialConfigService.selectSysSpecialConfigByConfigId(Long.valueOf(CommonConstants.K3_BEGIN_DATE));
            //获取初始化的参数
            String dd = sysSpecialConfig.getConfigValue();
            String sContent ="{\n" +
                    "    \"FormId\": \"SP_PickMtrl\",\n" +
                    "    \"FieldKeys\": \"FID,FBILLNO,FDATE,FDOCUMENTSTATUS,FSTOCKORGID,FMATERIALID,FmaterialName,FTRANSFERBIZTYPEID,FSpecification,FUNITID,FACTUALQTY,FDS,FSTOCKID,FAMOUNT\",\n" +
                    "    \"FilterString\": \"FDATE >= '" + dd + "'\",\n" +
                    "    \"OrderString\": \"\",\n" +
                    "    \"TopRowCount\": 0,\n" +
                    "    \"StartRow\": 0,\n" +
                    "    \"Limit\": 0\n" +
                    "}";
//            //定义组织接口调用格式
//            String sContent = "{\n" +
//                    "    \"FormId\": \"SP_PickMtrl\",\n" +
//                    "    \"FieldKeys\": \"FID,FBILLNO,FDATE,FDOCUMENTSTATUS,FSTOCKORGID,FMATERIALID,FmaterialName,FTRANSFERBIZTYPEID,FSpecification,FUNITID,FACTUALQTY,FDS,FSTOCKID,FAMOUNT\",\n" +
//                    "    \"FilterString\": \"\",\n" +
//                    "    \"OrderString\": \"\",\n" +
//                    "    \"TopRowCount\": 0,\n" +
//                    "    \"StartRow\": 0,\n" +
//                    "    \"Limit\": 0\n" +
//                    "}";
            //接口调用标识
            String sFormId = "SP_PickMtrl";
            //构成list
            List<List<Object>> list = api.executeBillQuery(sContent);
            //定义接受接口数据的集合
            List<K3SpPickmtrl> k3PList = new ArrayList<>();
            //循环遍历多维数组,根据下标为数据添加参数
            int countNum = 0;//总数
            if (list.size() > 0){
                for (int i = 0; i < list.size(); i++){
                    //初始化
                    K3SpPickmtrl k3p = new K3SpPickmtrl();
                    //源单ID
                    k3p.setFid((Long) list.get(i).get(0));
                    //单据编号
                    k3p.setFbillno(String.valueOf(list.get(i).get(1)));
                    //业务日期
                    k3p.setFdate(String.valueOf(list.get(i).get(2)));
                    //单据状态
                    k3p.setFdocumentStatus(String.valueOf(list.get(i).get(3)));
                    //发料组织ID
                    k3p.setFstockorgId(String.valueOf(list.get(i).get(4)));
                    //物料编码
                    k3p.setFmaterialId(String.valueOf(list.get(i).get(5)));
                    //物料名称
                    k3p.setFmaterialName(String.valueOf(list.get(i).get(6)));
                    //跨组织业务类型
                    k3p.setFtransferbiztypeId(String.valueOf(list.get(i).get(7)));
                    //规格
                    k3p.setFspecification(String.valueOf(list.get(i).get(8)));
                    //单位编号
                    k3p.setFunitid(String.valueOf(list.get(i).get(9)));
                    //实发数量
                    k3p.setFactualqty(new BigDecimal(list.get(i).get(10).toString()));
                    //栋舍
                    k3p.setFds(String.valueOf(list.get(i).get(11)));
                    //仓库
                    k3p.setFstockId(String.valueOf(list.get(i).get(12)));
                    //总成本
                    k3p.setFamount(new BigDecimal(String.valueOf(list.get(i).get(13))));
                    //构建新的集合
                    k3PList.add(k3p);
                }
            }else {
                return error("未从接口中获取数据，请检查接口");
            }
            //遍历解析后的数据，进行存储
            K3SpPickmtrl k3P = new K3SpPickmtrl();
            //检查历史数据
            List<K3SpPickmtrl> listK3p = k3SpPickmtrlService.selectK3SpPickmtrlList(k3P);
            if (k3PList.size() > listK3p.size()){
                System.out.println("数据条数" + k3PList.size());
                //删除原有记录
                k3SpPickmtrlService.deleteK3SpPickmtrlAll();
                //执行数据插入
                saveBatchVoid(k3PList);
                return success("数据执行成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return error("数据抓取失败，报错如下" + e.getMessage());
        }
        return success("数据执行成功");
    }

    /**
     *
     */
    public void saveBatchVoid(List kpList){
        //开启计时
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //用于存储批量保存的集合
        List<K3SpPickmtrl> k3pArrayList = new ArrayList<>();
        for (int i = 0; i < kpList.size(); i++){
            K3SpPickmtrl pickmtrl = (K3SpPickmtrl) kpList.get(i);
            //初始化
            K3SpPickmtrl k3p = new K3SpPickmtrl();
            //源单ID
            k3p.setFid(pickmtrl.getFid());
            //单据编号
            k3p.setFbillno(pickmtrl.getFbillno());
            //业务日期
            k3p.setFdate(pickmtrl.getFdate());
            //单据状态
            k3p.setFdocumentStatus(pickmtrl.getFdocumentStatus());
            //发料组织ID
            k3p.setFstockorgId(pickmtrl.getFstockorgId());
            //根据组织内码查询名称 当查询不到组织时，暂时处理
            K3Organization k3Organization = k3OrganizationService.selectK3OrganizationByForgid(Long.parseLong(pickmtrl.getFstockorgId()));
            if (k3Organization == null){
                k3p.setFstockorgName(pickmtrl.getFstockorgId());
            }else {
                k3p.setFstockorgName(k3Organization.getFname());
            }
            //物料编码
            k3p.setFmaterialId(pickmtrl.getFmaterialId());
            //物料名称
            k3p.setFmaterialName(pickmtrl.getFmaterialName());
            //跨组织业务类型
            k3p.setFtransferbiztypeId(pickmtrl.getFtransferbiztypeId());
            //规格
            k3p.setFspecification(pickmtrl.getFspecification());
            //单位编号
            k3p.setFunitid(pickmtrl.getFunitid());
            //实发数量
            k3p.setFactualqty(pickmtrl.getFactualqty());
            //栋舍
            k3p.setFds(pickmtrl.getFds());
            //仓库
            k3p.setFstockId(pickmtrl.getFstockId());
            //总成本
            k3p.setFamount(pickmtrl.getFamount());
            //创建人
            k3p.setCreateBy(SecurityUtils.getUsername());
            //创建时间
            k3p.setCreateTime(DateUtils.getNowDate());
            //构建新的集合
            k3pArrayList.add(k3p);
        }
        System.out.println(k3pArrayList.size());
        //调用批量插入
        k3SpPickmtrlService.saveBeach(k3pArrayList);
        stopWatch.stop();
        System.out.println("使用sqlSessionFactory实现批量插入：" + stopWatch.getTotalTimeMillis() + "毫秒");
    }
}
