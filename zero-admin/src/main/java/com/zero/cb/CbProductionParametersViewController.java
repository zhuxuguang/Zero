package com.zero.cb;

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
import com.zero.system.cb.domain.CbProductionParametersView;
import com.zero.system.cb.service.ICbProductionParametersViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 成本分析数据获取Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-20
 */
@RestController
@RequestMapping("/system/cbProductionParametersView")
public class CbProductionParametersViewController extends BaseController
{
    @Autowired
    private ICbProductionParametersViewService cbProductionParametersViewService;

    /**
     * 查询成本分析数据获取列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionParametersView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbProductionParametersView cbProductionParametersView)
    {
        startPage();
        List<CbProductionParametersView> list = cbProductionParametersViewService.selectCbProductionParametersViewList(cbProductionParametersView);
        return getDataTable(list);
    }

    /**
     * 导出成本分析数据获取列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionParametersView:export')")
    @Log(title = "成本分析数据获取", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbProductionParametersView cbProductionParametersView)
    {
        List<CbProductionParametersView> list = cbProductionParametersViewService.selectCbProductionParametersViewList(cbProductionParametersView);
        ExcelUtil<CbProductionParametersView> util = new ExcelUtil<CbProductionParametersView>(CbProductionParametersView.class);
        util.exportExcel(response, list, "成本分析数据获取数据");
    }

    /**
     * 获取成本分析数据获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionParametersView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbProductionParametersViewService.selectCbProductionParametersViewByType(type));
    }

    /**
     * 新增成本分析数据获取
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionParametersView:add')")
    @Log(title = "成本分析数据获取", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbProductionParametersView cbProductionParametersView)
    {
        return toAjax(cbProductionParametersViewService.insertCbProductionParametersView(cbProductionParametersView));
    }

    /**
     * 修改成本分析数据获取
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionParametersView:edit')")
    @Log(title = "成本分析数据获取", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbProductionParametersView cbProductionParametersView)
    {
        return toAjax(cbProductionParametersViewService.updateCbProductionParametersView(cbProductionParametersView));
    }

    /**
     * 删除成本分析数据获取
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionParametersView:remove')")
    @Log(title = "成本分析数据获取", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbProductionParametersViewService.deleteCbProductionParametersViewByTypes(types));
    }
}
