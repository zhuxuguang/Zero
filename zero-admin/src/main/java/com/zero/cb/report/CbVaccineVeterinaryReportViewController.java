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
import com.zero.system.cb.report.domain.CbVaccineVeterinaryReportView;
import com.zero.system.cb.report.service.ICbVaccineVeterinaryReportViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 疫苗-兽药报表视图Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@RestController
@RequestMapping("/system/cbVaccineVeterinaryReportView")
public class CbVaccineVeterinaryReportViewController extends BaseController
{
    @Autowired
    private ICbVaccineVeterinaryReportViewService cbVaccineVeterinaryReportViewService;

    /**
     * 查询疫苗-兽药报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbVaccineVeterinaryReportView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        startPage();
        List<CbVaccineVeterinaryReportView> list = cbVaccineVeterinaryReportViewService.selectCbVaccineVeterinaryReportViewList(cbVaccineVeterinaryReportView);
        return getDataTable(list);
    }

    /**
     * 导出疫苗-兽药报表视图列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbVaccineVeterinaryReportView:export')")
    @Log(title = "疫苗-兽药报表视图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        List<CbVaccineVeterinaryReportView> list = cbVaccineVeterinaryReportViewService.selectCbVaccineVeterinaryReportViewList(cbVaccineVeterinaryReportView);
        ExcelUtil<CbVaccineVeterinaryReportView> util = new ExcelUtil<CbVaccineVeterinaryReportView>(CbVaccineVeterinaryReportView.class);
        util.exportExcel(response, list, "疫苗-兽药报表视图数据");
    }

    /**
     * 获取疫苗-兽药报表视图详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbVaccineVeterinaryReportView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbVaccineVeterinaryReportViewService.selectCbVaccineVeterinaryReportViewByType(type));
    }

    /**
     * 新增疫苗-兽药报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbVaccineVeterinaryReportView:add')")
    @Log(title = "疫苗-兽药报表视图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        return toAjax(cbVaccineVeterinaryReportViewService.insertCbVaccineVeterinaryReportView(cbVaccineVeterinaryReportView));
    }

    /**
     * 修改疫苗-兽药报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbVaccineVeterinaryReportView:edit')")
    @Log(title = "疫苗-兽药报表视图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        return toAjax(cbVaccineVeterinaryReportViewService.updateCbVaccineVeterinaryReportView(cbVaccineVeterinaryReportView));
    }

    /**
     * 删除疫苗-兽药报表视图
     */
    @PreAuthorize("@ss.hasPermi('system:cbVaccineVeterinaryReportView:remove')")
    @Log(title = "疫苗-兽药报表视图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbVaccineVeterinaryReportViewService.deleteCbVaccineVeterinaryReportViewByTypes(types));
    }
}
