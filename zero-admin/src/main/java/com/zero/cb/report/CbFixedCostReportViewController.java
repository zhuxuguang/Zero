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
import com.zero.system.cb.report.domain.CbFixedCostReportView;
import com.zero.system.cb.report.service.ICbFixedCostReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 固定成本报表视图Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-23
 */
@RestController
@RequestMapping("/system/cb/report/cbFixedCostReportView")
public class CbFixedCostReportViewController extends BaseController
{
    @Autowired
    private ICbFixedCostReportViewService cbFixedCostReportViewService;

    /**
     * 查询固定成本报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFixedCostReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbFixedCostReportView cbFixedCostReportView)
    {
        startPage();
        List<CbFixedCostReportView> list = cbFixedCostReportViewService.selectCbFixedCostReportViewList(cbFixedCostReportView);
        return getDataTable(list);
    }

    /**
     * 导出固定成本报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFixedCostReportView:export')")
    @Log(title = "固定成本报表视图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbFixedCostReportView cbFixedCostReportView)
    {
        List<CbFixedCostReportView> list = cbFixedCostReportViewService.selectCbFixedCostReportViewList(cbFixedCostReportView);
        ExcelUtil<CbFixedCostReportView> util = new ExcelUtil<CbFixedCostReportView>(CbFixedCostReportView.class);
        util.exportExcel(response, list, "固定成本报表视图数据");
    }

    /**
     * 获取固定成本报表视图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbFixedCostReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbFixedCostReportViewService.selectCbFixedCostReportViewByType(type));
    }

    /**
     * 新增固定成本报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbFixedCostReportView:add')")
    @Log(title = "固定成本报表视图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbFixedCostReportView cbFixedCostReportView)
    {
        return toAjax(cbFixedCostReportViewService.insertCbFixedCostReportView(cbFixedCostReportView));
    }

    /**
     * 修改固定成本报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbFixedCostReportView:edit')")
    @Log(title = "固定成本报表视图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbFixedCostReportView cbFixedCostReportView)
    {
        return toAjax(cbFixedCostReportViewService.updateCbFixedCostReportView(cbFixedCostReportView));
    }

    /**
     * 删除固定成本报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbFixedCostReportView:remove')")
    @Log(title = "固定成本报表视图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbFixedCostReportViewService.deleteCbFixedCostReportViewByTypes(types));
    }
}
