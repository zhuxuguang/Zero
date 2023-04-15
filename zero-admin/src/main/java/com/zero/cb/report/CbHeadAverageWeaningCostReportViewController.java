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
import com.zero.system.cb.report.domain.CbHeadAverageWeaningCostReportView;
import com.zero.system.cb.report.service.ICbHeadAverageWeaningCostReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 头均断奶成本计算Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
@RestController
@RequestMapping("/system/cbHeadAverageWeaningCostReportView")
public class CbHeadAverageWeaningCostReportViewController extends BaseController
{
    @Autowired
    private ICbHeadAverageWeaningCostReportViewService cbHeadAverageWeaningCostReportViewService;

    /**
     * 查询头均断奶成本计算列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbHeadAverageWeaningCostReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        startPage();
        List<CbHeadAverageWeaningCostReportView> list = cbHeadAverageWeaningCostReportViewService.selectCbHeadAverageWeaningCostReportViewList(cbHeadAverageWeaningCostReportView);
        return getDataTable(list);
    }

    /**
     * 导出头均断奶成本计算列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbHeadAverageWeaningCostReportView:export')")
    @Log(title = "头均断奶成本计算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        List<CbHeadAverageWeaningCostReportView> list = cbHeadAverageWeaningCostReportViewService.selectCbHeadAverageWeaningCostReportViewList(cbHeadAverageWeaningCostReportView);
        ExcelUtil<CbHeadAverageWeaningCostReportView> util = new ExcelUtil<CbHeadAverageWeaningCostReportView>(CbHeadAverageWeaningCostReportView.class);
        util.exportExcel(response, list, "头均断奶成本计算数据");
    }

    /**
     * 获取头均断奶成本计算详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbHeadAverageWeaningCostReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbHeadAverageWeaningCostReportViewService.selectCbHeadAverageWeaningCostReportViewByType(type));
    }

    /**
     * 新增头均断奶成本计算
     */
    @PreAuthorize("@ss.hasPermi('system:cbHeadAverageWeaningCostReportView:add')")
    @Log(title = "头均断奶成本计算", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        return toAjax(cbHeadAverageWeaningCostReportViewService.insertCbHeadAverageWeaningCostReportView(cbHeadAverageWeaningCostReportView));
    }

    /**
     * 修改头均断奶成本计算
     */
    @PreAuthorize("@ss.hasPermi('system:cbHeadAverageWeaningCostReportView:edit')")
    @Log(title = "头均断奶成本计算", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        return toAjax(cbHeadAverageWeaningCostReportViewService.updateCbHeadAverageWeaningCostReportView(cbHeadAverageWeaningCostReportView));
    }

    /**
     * 删除头均断奶成本计算
     */
    @PreAuthorize("@ss.hasPermi('system:cbHeadAverageWeaningCostReportView:remove')")
    @Log(title = "头均断奶成本计算", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbHeadAverageWeaningCostReportViewService.deleteCbHeadAverageWeaningCostReportViewByTypes(types));
    }
}
