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
import com.zero.system.cb.report.domain.CbReceiptGoodsReportView;
import com.zero.system.cb.report.service.ICbReceiptGoodsReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 物资领用报表视图Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@RestController
@RequestMapping("/system/cbReceiptGoodsReportView")
public class CbReceiptGoodsReportViewController extends BaseController
{
    @Autowired
    private ICbReceiptGoodsReportViewService cbReceiptGoodsReportViewService;

    /**
     * 查询物资领用报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbReceiptGoodsReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        startPage();
        List<CbReceiptGoodsReportView> list = cbReceiptGoodsReportViewService.selectCbReceiptGoodsReportViewList(cbReceiptGoodsReportView);
        return getDataTable(list);
    }

    /**
     * 导出物资领用报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbReceiptGoodsReportView:export')")
    @Log(title = "物资领用报表视图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        List<CbReceiptGoodsReportView> list = cbReceiptGoodsReportViewService.selectCbReceiptGoodsReportViewList(cbReceiptGoodsReportView);
        ExcelUtil<CbReceiptGoodsReportView> util = new ExcelUtil<CbReceiptGoodsReportView>(CbReceiptGoodsReportView.class);
        util.exportExcel(response, list, "物资领用报表视图数据");
    }

    /**
     * 获取物资领用报表视图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbReceiptGoodsReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbReceiptGoodsReportViewService.selectCbReceiptGoodsReportViewByType(type));
    }

    /**
     * 新增物资领用报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbReceiptGoodsReportView:add')")
    @Log(title = "物资领用报表视图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        return toAjax(cbReceiptGoodsReportViewService.insertCbReceiptGoodsReportView(cbReceiptGoodsReportView));
    }

    /**
     * 修改物资领用报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbReceiptGoodsReportView:edit')")
    @Log(title = "物资领用报表视图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        return toAjax(cbReceiptGoodsReportViewService.updateCbReceiptGoodsReportView(cbReceiptGoodsReportView));
    }

    /**
     * 删除物资领用报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbReceiptGoodsReportView:remove')")
    @Log(title = "物资领用报表视图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbReceiptGoodsReportViewService.deleteCbReceiptGoodsReportViewByTypes(types));
    }
}
