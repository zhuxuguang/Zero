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
import com.zero.system.cb.report.domain.CbAvgAdfiCostView;
import com.zero.system.cb.report.service.ICbAvgAdfiCostViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 头均日采食量和成本计算视图Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@RestController
@RequestMapping("/system/cbAvgAdfiCostView")
public class CbAvgAdfiCostViewController extends BaseController
{
    @Autowired
    private ICbAvgAdfiCostViewService cbAvgAdfiCostViewService;

    /**
     * 查询头均日采食量和成本计算视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbAvgAdfiCostView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        startPage();
        List<CbAvgAdfiCostView> list = cbAvgAdfiCostViewService.selectCbAvgAdfiCostViewList(cbAvgAdfiCostView);
        return getDataTable(list);
    }

    /**
     * 导出头均日采食量和成本计算视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbAvgAdfiCostView:export')")
    @Log(title = "头均日采食量和成本计算视图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        List<CbAvgAdfiCostView> list = cbAvgAdfiCostViewService.selectCbAvgAdfiCostViewList(cbAvgAdfiCostView);
        ExcelUtil<CbAvgAdfiCostView> util = new ExcelUtil<CbAvgAdfiCostView>(CbAvgAdfiCostView.class);
        util.exportExcel(response, list, "头均日采食量和成本计算视图数据");
    }

    /**
     * 获取头均日采食量和成本计算视图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbAvgAdfiCostView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbAvgAdfiCostViewService.selectCbAvgAdfiCostViewByType(type));
    }

    /**
     * 新增头均日采食量和成本计算视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbAvgAdfiCostView:add')")
    @Log(title = "头均日采食量和成本计算视图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        return toAjax(cbAvgAdfiCostViewService.insertCbAvgAdfiCostView(cbAvgAdfiCostView));
    }

    /**
     * 修改头均日采食量和成本计算视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbAvgAdfiCostView:edit')")
    @Log(title = "头均日采食量和成本计算视图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        return toAjax(cbAvgAdfiCostViewService.updateCbAvgAdfiCostView(cbAvgAdfiCostView));
    }

    /**
     * 删除头均日采食量和成本计算视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbAvgAdfiCostView:remove')")
    @Log(title = "头均日采食量和成本计算视图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbAvgAdfiCostViewService.deleteCbAvgAdfiCostViewByTypes(types));
    }
}
