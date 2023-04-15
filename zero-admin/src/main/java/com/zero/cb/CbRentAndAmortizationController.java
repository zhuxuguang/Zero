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
import com.zero.system.cb.domain.CbRentAndAmortization;
import com.zero.system.cb.service.ICbRentAndAmortizationService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 租金及摊销Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-12
 */
@RestController
@RequestMapping("/system/cb/cbRentAndAmortization")
public class CbRentAndAmortizationController extends BaseController
{
    @Autowired
    private ICbRentAndAmortizationService cbRentAndAmortizationService;

    /**
     * 查询租金及摊销列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentAndAmortization:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbRentAndAmortization cbRentAndAmortization)
    {
        startPage();
        List<CbRentAndAmortization> list = cbRentAndAmortizationService.selectCbRentAndAmortizationList(cbRentAndAmortization);
        return getDataTable(list);
    }

    /**
     * 导出租金及摊销列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentAndAmortization:export')")
    @Log(title = "租金及摊销", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbRentAndAmortization cbRentAndAmortization)
    {
        List<CbRentAndAmortization> list = cbRentAndAmortizationService.selectCbRentAndAmortizationList(cbRentAndAmortization);
        ExcelUtil<CbRentAndAmortization> util = new ExcelUtil<CbRentAndAmortization>(CbRentAndAmortization.class);
        util.exportExcel(response, list, "租金及摊销数据");
    }

    /**
     * 获取租金及摊销详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentAndAmortization:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbRentAndAmortizationService.selectCbRentAndAmortizationById(id));
    }

    /**
     * 新增租金及摊销
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentAndAmortization:add')")
    @Log(title = "租金及摊销", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbRentAndAmortization cbRentAndAmortization)
    {
        return toAjax(cbRentAndAmortizationService.insertCbRentAndAmortization(cbRentAndAmortization));
    }

    /**
     * 修改租金及摊销
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentAndAmortization:edit')")
    @Log(title = "租金及摊销", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbRentAndAmortization cbRentAndAmortization)
    {
        return toAjax(cbRentAndAmortizationService.updateCbRentAndAmortization(cbRentAndAmortization));
    }

    /**
     * 删除租金及摊销
     */
    @PreAuthorize("@ss.hasPermi('system:cbRentAndAmortization:remove')")
    @Log(title = "租金及摊销", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbRentAndAmortizationService.deleteCbRentAndAmortizationByIds(ids));
    }
}
