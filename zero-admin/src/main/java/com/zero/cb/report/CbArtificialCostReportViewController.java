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
import com.zero.system.cb.report.domain.CbArtificialCostReportView;
import com.zero.system.cb.report.service.ICbArtificialCostReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 人工成本计算视图Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@RestController
@RequestMapping("/system/cbArtificialCostReportView")
public class CbArtificialCostReportViewController extends BaseController
{
    @Autowired
    private ICbArtificialCostReportViewService cbArtificialCostReportViewService;

    /**
     * 查询人工成本计算视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificialCostReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbArtificialCostReportView cbArtificialCostReportView)
    {
        startPage();
        List<CbArtificialCostReportView> list = cbArtificialCostReportViewService.selectCbArtificialCostReportViewList(cbArtificialCostReportView);
        return getDataTable(list);
    }

    /**
     * 导出人工成本计算视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificialCostReportView:export')")
    @Log(title = "人工成本计算视图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbArtificialCostReportView cbArtificialCostReportView)
    {
        List<CbArtificialCostReportView> list = cbArtificialCostReportViewService.selectCbArtificialCostReportViewList(cbArtificialCostReportView);
        ExcelUtil<CbArtificialCostReportView> util = new ExcelUtil<CbArtificialCostReportView>(CbArtificialCostReportView.class);
        util.exportExcel(response, list, "人工成本计算视图数据");
    }

    /**
     * 获取人工成本计算视图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificialCostReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbArtificialCostReportViewService.selectCbArtificialCostReportViewByType(type));
    }

    /**
     * 新增人工成本计算视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificialCostReportView:add')")
    @Log(title = "人工成本计算视图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbArtificialCostReportView cbArtificialCostReportView)
    {
        return toAjax(cbArtificialCostReportViewService.insertCbArtificialCostReportView(cbArtificialCostReportView));
    }

    /**
     * 修改人工成本计算视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificialCostReportView:edit')")
    @Log(title = "人工成本计算视图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbArtificialCostReportView cbArtificialCostReportView)
    {
        return toAjax(cbArtificialCostReportViewService.updateCbArtificialCostReportView(cbArtificialCostReportView));
    }

    /**
     * 删除人工成本计算视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificialCostReportView:remove')")
    @Log(title = "人工成本计算视图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbArtificialCostReportViewService.deleteCbArtificialCostReportViewByTypes(types));
    }
}
