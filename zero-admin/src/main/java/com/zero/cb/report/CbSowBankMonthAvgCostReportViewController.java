package com.zero.cb.report;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.zero.system.cb.report.domain.CbSowBankMonthAvgCostReportView;
import com.zero.system.cb.report.service.ICbSowBankMonthAvgCostReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 母猪存栏月平均成本(元/头)Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
@RestController
@RequestMapping("/system/cbSowBankMonthAvgCostReportView")
public class CbSowBankMonthAvgCostReportViewController extends BaseController
{
    @Autowired
    private ICbSowBankMonthAvgCostReportViewService cbSowBankMonthAvgCostReportViewService;

    /**
     * 查询母猪存栏月平均成本(元/头)列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbSowBankMonthAvgCostReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        startPage();
        List<CbSowBankMonthAvgCostReportView> list = cbSowBankMonthAvgCostReportViewService.selectCbSowBankMonthAvgCostReportViewList(cbSowBankMonthAvgCostReportView);
        return getDataTable(list);
    }

    /**
     * 导出母猪存栏月平均成本(元/头)列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbSowBankMonthAvgCostReportView:export')")
    @Log(title = "母猪存栏月平均成本(元/头)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        List<CbSowBankMonthAvgCostReportView> list = cbSowBankMonthAvgCostReportViewService.selectCbSowBankMonthAvgCostReportViewList(cbSowBankMonthAvgCostReportView);
        ExcelUtil<CbSowBankMonthAvgCostReportView> util = new ExcelUtil<CbSowBankMonthAvgCostReportView>(CbSowBankMonthAvgCostReportView.class);
        util.exportExcel(response, list, "母猪存栏月平均成本(元/头)数据");
    }

    /**
     * 获取母猪存栏月平均成本(元/头)详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbSowBankMonthAvgCostReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbSowBankMonthAvgCostReportViewService.selectCbSowBankMonthAvgCostReportViewByType(type));
    }

    /**
     * 新增母猪存栏月平均成本(元/头)
     */
    @PreAuthorize("@ss.hasPermi('system:cbSowBankMonthAvgCostReportView:add')")
    @Log(title = "母猪存栏月平均成本(元/头)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        return toAjax(cbSowBankMonthAvgCostReportViewService.insertCbSowBankMonthAvgCostReportView(cbSowBankMonthAvgCostReportView));
    }

    /**
     * 修改母猪存栏月平均成本(元/头)
     */
    @PreAuthorize("@ss.hasPermi('system:cbSowBankMonthAvgCostReportView:edit')")
    @Log(title = "母猪存栏月平均成本(元/头)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        return toAjax(cbSowBankMonthAvgCostReportViewService.updateCbSowBankMonthAvgCostReportView(cbSowBankMonthAvgCostReportView));
    }

    /**
     * 删除母猪存栏月平均成本(元/头)
     */
    @PreAuthorize("@ss.hasPermi('system:cbSowBankMonthAvgCostReportView:remove')")
    @Log(title = "母猪存栏月平均成本(元/头)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbSowBankMonthAvgCostReportViewService.deleteCbSowBankMonthAvgCostReportViewByTypes(types));
    }
}
