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
import com.zero.system.cb.report.domain.CbFabricateReportView;
import com.zero.system.cb.report.service.ICbFabricateReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 制造费用报表视图Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@RestController
@RequestMapping("/system/cbFabricateReportView")
public class CbFabricateReportViewController extends BaseController
{
    @Autowired
    private ICbFabricateReportViewService cbFabricateReportViewService;

    /**
     * 查询制造费用报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFabricateReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbFabricateReportView cbFabricateReportView)
    {
        startPage();
        List<CbFabricateReportView> list = cbFabricateReportViewService.selectCbFabricateReportViewList(cbFabricateReportView);
        return getDataTable(list);
    }

    /**
     * 导出制造费用报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFabricateReportView:export')")
    @Log(title = "制造费用报表视图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbFabricateReportView cbFabricateReportView)
    {
        List<CbFabricateReportView> list = cbFabricateReportViewService.selectCbFabricateReportViewList(cbFabricateReportView);
        ExcelUtil<CbFabricateReportView> util = new ExcelUtil<CbFabricateReportView>(CbFabricateReportView.class);
        util.exportExcel(response, list, "制造费用报表视图数据");
    }

    /**
     * 获取制造费用报表视图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbFabricateReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbFabricateReportViewService.selectCbFabricateReportViewByType(type));
    }

    /**
     * 新增制造费用报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbFabricateReportView:add')")
    @Log(title = "制造费用报表视图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbFabricateReportView cbFabricateReportView)
    {
        return toAjax(cbFabricateReportViewService.insertCbFabricateReportView(cbFabricateReportView));
    }

    /**
     * 修改制造费用报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbFabricateReportView:edit')")
    @Log(title = "制造费用报表视图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbFabricateReportView cbFabricateReportView)
    {
        return toAjax(cbFabricateReportViewService.updateCbFabricateReportView(cbFabricateReportView));
    }

    /**
     * 删除制造费用报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbFabricateReportView:remove')")
    @Log(title = "制造费用报表视图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbFabricateReportViewService.deleteCbFabricateReportViewByTypes(types));
    }
}
