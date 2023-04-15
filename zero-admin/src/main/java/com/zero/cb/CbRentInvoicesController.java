package com.zero.cb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletResponse;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.common.utils.CbConstants;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.SecurityUtils;
import com.zero.common.utils.StringUtils;
import com.zero.system.cb.domain.CbRentAndAmortization;
import com.zero.system.cb.service.ICbRentAndAmortizationService;
import com.zero.system.service.ISysDeptService;
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
import com.zero.system.cb.domain.CbRentInvoices;
import com.zero.system.cb.service.ICbRentInvoicesService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 租金录入单据Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-08
 */
@RestController
@RequestMapping("/system/cb/cbRentInvoices")
public class CbRentInvoicesController extends BaseController
{
    @Autowired
    private ICbRentInvoicesService cbRentInvoicesService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ICbRentAndAmortizationService cbRentAndAmortizationService;

    /**
     * 查询租金录入单据列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbRentInvoices cbRentInvoices)
    {
        startPage();
        List<CbRentInvoices> list = cbRentInvoicesService.selectCbRentInvoicesList(cbRentInvoices);
        return getDataTable(list);
    }

    /**
     * 导出租金录入单据列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:export')")
    @Log(title = "租金录入单据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbRentInvoices cbRentInvoices)
    {
        List<CbRentInvoices> list = cbRentInvoicesService.selectCbRentInvoicesList(cbRentInvoices);
        ExcelUtil<CbRentInvoices> util = new ExcelUtil<CbRentInvoices>(CbRentInvoices.class);
        util.exportExcel(response, list, "租金录入单据数据");
    }

    /**
     * 获取租金录入单据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbRentInvoicesService.selectCbRentInvoicesById(id));
    }

    /**
     * 新增租金录入单据
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:add')")
    @Log(title = "租金录入单据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbRentInvoices cbRentInvoices)
    {
        //组织名称
        SysDept dept = deptService.selectDeptById(cbRentInvoices.getHoggeryId());
        cbRentInvoices.setHoggeryName(dept.getDeptName());
        //公司名称
        SysDept dept_ = deptService.selectDeptById(cbRentInvoices.getCompanyId());
        cbRentInvoices.setCompanyName(dept_.getDeptName());
        return toAjax(cbRentInvoicesService.insertCbRentInvoices(cbRentInvoices));
    }

    /**
     * 修改租金录入单据
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:edit')")
    @Log(title = "租金录入单据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbRentInvoices cbRentInvoices)
    {
        return toAjax(cbRentInvoicesService.updateCbRentInvoices(cbRentInvoices));
    }

    /**
     * 删除租金录入单据
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:remove')")
    @Log(title = "租金录入单据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbRentInvoicesService.deleteCbRentInvoicesByIds(ids));
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }






    /**
     * 审核租金录入单据
     */
    //事务回滚
    @Transactional(rollbackFor = { Exception.class })
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:check')")
    @Log(title = "审核租金录入单据", businessType = BusinessType.CHECK)
    @DeleteMapping("/check/{cid}")
    public AjaxResult check(@PathVariable Long cid)
    {
        AtomicInteger successNum = new AtomicInteger();
        StringBuilder successMsg = new StringBuilder();
        //根据ID查询
        CbRentInvoices cbRentInvoices = cbRentInvoicesService.selectCbRentInvoicesById(cid);
        //核对单据状态
        if (StringUtils.isNotNull(cid) && cbRentInvoices.getDocumentStatus().equals(CbConstants.SAVE_STATUS)){
            try{
                //调用insertRentAndAmortizationVoid插入租金及摊销记录CbRentAndAmortization
                insertRentAndAmortizationVoid(cbRentInvoices);
                //修改为审核状态
                cbRentInvoices.setDocumentStatus(CbConstants.CHECK_STATUS);
                return success(cbRentInvoicesService.updateCbRentInvoices(cbRentInvoices));
            }catch (Exception e){
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return AjaxResult.error("单据审核失败，请检查数据。异常信息为" + e.getMessage());
            }
        }
        return AjaxResult.error("单据状态不对，请核对数据");
    }


    /**
     * 反审核租金录入单据
     */
    //事务回滚
    @Transactional(rollbackFor = { Exception.class })
    @PreAuthorize("@ss.hasPermi('system:cbRentInvoices:onCheck')")
    @Log(title = "租金录入单据", businessType = BusinessType.ON_CHECK)
    @PostMapping("/onCheck/{id}")
    public AjaxResult onCheck(@PathVariable Long id){
        //根据ID查询
        CbRentInvoices cbRentInvoices = cbRentInvoicesService.selectCbRentInvoicesById(id);
        //核对单据状态
        if (StringUtils.isNotNull(id) && cbRentInvoices.getDocumentStatus().equals(CbConstants.CHECK_STATUS)){
            try{
                if (cbRentInvoices.getDocumentStatus().equals(CbConstants.CHECK_STATUS)){
                    //调用deleteRentAndAmortizationVoid删除租金及摊销记录CbRentAndAmortization
                    deleteRentAndAmortizationVoid(cbRentInvoices.getId());
                    //修改为保存状态
                    cbRentInvoices.setDocumentStatus(CbConstants.SAVE_STATUS);
                    return success(cbRentInvoicesService.updateCbRentInvoices(cbRentInvoices));
                }
            }catch (Exception e){
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return AjaxResult.error("单据反审失败，请检查数据。异常信息为" + e.getMessage());
            }
        }
        return AjaxResult.error("单据状态不对，请核对数据");
    }

    /**
     * 审核后插入租金及摊销记录
     * @param cbRentInvoices
     */
    void insertRentAndAmortizationVoid(CbRentInvoices cbRentInvoices){
        //初始化摊销记录
        CbRentAndAmortization cbRentAndAmortization = new CbRentAndAmortization();
        //将数据cbRentInvoices赋予cbRentAndAmortization 业务日期 资产名称 场别 公司 费用类型 资产原值 摊销起始月份 摊销结束月份 核算维度 备注
        //数据初始化赋值
        cbRentAndAmortization.setRiId(cbRentInvoices.getId());
        cbRentAndAmortization.setBusinessDate(cbRentInvoices.getBusinessDate());
        cbRentAndAmortization.setAssetName(cbRentInvoices.getAssetName());
        cbRentAndAmortization.setHoggeryId(cbRentInvoices.getHoggeryId());
        cbRentAndAmortization.setHoggeryName(cbRentInvoices.getHoggeryName());
        cbRentAndAmortization.setCompanyId(cbRentInvoices.getCompanyId());
        cbRentAndAmortization.setCompanyName(cbRentInvoices.getCompanyName());
        cbRentAndAmortization.setCostTypes(cbRentInvoices.getCostTypes());
        cbRentAndAmortization.setInitialAssetValue(cbRentInvoices.getInitialAssetValue());
        cbRentAndAmortization.setAmortizeStartMonth(cbRentInvoices.getAmortizeStartMonth());
        cbRentAndAmortization.setAmortizeEndMonth(cbRentInvoices.getAmortizeEndMonth());
        cbRentAndAmortization.setDimensionOfAccounting(cbRentInvoices.getDimensionOfAccounting());
        cbRentAndAmortization.setRemake(cbRentInvoices.getRemake());

        //日期处理-根据摊销起始终止日期处理年-月-摊销日期
        //摊销开始月份
        Date startTime = cbRentAndAmortization.getAmortizeStartMonth();
        //摊销终止月份
        Date endTime = cbRentAndAmortization.getAmortizeEndMonth();
        //计算两个日期相差的月数
        int sm = DateUtils.getMonth(startTime, endTime) + 1;
        //摊销月数添加
        cbRentAndAmortization.setAmortizeMonths(String.valueOf(sm));
        //平均摊销额 资产原值/摊销月数
        BigDecimal bsm = new BigDecimal(sm);
        //向上约2位，暂不考虑向下或四舍五入
        BigDecimal avgAm = cbRentAndAmortization.getInitialAssetValue().divide(bsm, BigDecimal.ROUND_CEILING);
        //本月摊销额
        cbRentAndAmortization.setInstantAmortizedMoney(avgAm);
        //获取两个日期之间的所有月份 (年月)
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        //日期转换为String类型的
        String st = DateUtils.chargeDate(startTime);
        String et = DateUtils.chargeDate(endTime);
        //获取数据集合
        list = DateUtils.getMonthBetweenDate(st, et);
        final int[] successNum = {0};
        //处理list集合将数据补充到数据中
        if (!list.equals("")){
            String[] obj = StringUtils.join(list,",").split(",");
            if (obj.length>1){
                Arrays.stream(obj).forEach(str->{
                    successNum[0]++;
                    int finalSuccessNum = successNum[0];
                    //str代表着日期2023-01
                    //年
                    String cy = str.substring(0,4);
                    cbRentAndAmortization.setCbYear(cy);
                    //月
                    String cm = str.substring(5,7);
                    cbRentAndAmortization.setCbMonth(cm);
                    //业务日期-摊销日期
                    String data = DateUtils.getLastday(cy, cm);
                    cbRentAndAmortization.setBusinessDate(DateUtils.parseDate(data));
                    //已摊销月份
                    //摊销数据计算
                    amortizeVoid(cbRentAndAmortization, finalSuccessNum);
                    //创建者
                    cbRentAndAmortization.setCreateBy(SecurityUtils.getUsername());
                    //创建日期
                    cbRentAndAmortization.setCreateTime(DateUtils.getNowDate());
                    cbRentAndAmortizationService.insertCbRentAndAmortization(cbRentAndAmortization);
                });
            }
        }
    }

    /**
     * 摊销计算
     * @param cbRentAndAmortization
     */
    private static void amortizeVoid(CbRentAndAmortization cbRentAndAmortization, int successNum){
        //已摊销月数 记录本次
        cbRentAndAmortization.setAlreadyAmortizedMonths(String.valueOf(successNum));
        //当跨入12月时，考虑小数，切换计算逻辑
        if (successNum == 12){
            //前面已完成的摊销金额
            BigDecimal amm_ = cbRentAndAmortization.getInstantAmortizedMoney().multiply(new BigDecimal(11));
            //本月摊销额 = 原值 - 已完成的摊销金额
            BigDecimal avgAm = cbRentAndAmortization.getInitialAssetValue().subtract(amm_);
            //本月摊销额
            cbRentAndAmortization.setInstantAmortizedMoney(avgAm);
            //本月已摊销金额
            cbRentAndAmortization.setAlreadyAmortizedMoney(amm_.add(avgAm));
            //余额
            BigDecimal b_ = cbRentAndAmortization.getInitialAssetValue().subtract(amm_.add(avgAm));
            cbRentAndAmortization.setBalance(b_);
        }else {
            //已摊销金额
            BigDecimal amm = cbRentAndAmortization.getInstantAmortizedMoney().multiply(BigDecimal.valueOf(successNum));
            cbRentAndAmortization.setAlreadyAmortizedMoney(amm);
            //余额
            BigDecimal b = cbRentAndAmortization.getInitialAssetValue().subtract(amm);
            cbRentAndAmortization.setBalance(b);
        }
    }


    /**
     * 反审单据时需要将生成明细删除
     * @param id
     */
    void deleteRentAndAmortizationVoid(Long id){
        cbRentAndAmortizationService.deleteCbRentAndAmortizationByRiId(id);
    }

}
