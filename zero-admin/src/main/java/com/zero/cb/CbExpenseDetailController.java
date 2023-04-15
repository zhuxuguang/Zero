package com.zero.cb;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zero.system.cb.domain.CbProductionTarget;
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
import com.zero.system.cb.domain.CbExpenseDetail;
import com.zero.system.cb.service.ICbExpenseDetailService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 费用明细Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-17
 */
@RestController
@RequestMapping("/system/cb/cbExpenseDetail")
public class CbExpenseDetailController extends BaseController
{
    @Autowired
    private ICbExpenseDetailService cbExpenseDetailService;

    /**
     * 查询费用明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbExpenseDetail cbExpenseDetail)
    {
        startPage();
        List<CbExpenseDetail> list = cbExpenseDetailService.selectCbExpenseDetailList(cbExpenseDetail);
        return getDataTable(list);
    }

    /**
     * 导出费用明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:export')")
    @Log(title = "费用明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbExpenseDetail cbExpenseDetail)
    {
        List<CbExpenseDetail> list = cbExpenseDetailService.selectCbExpenseDetailList(cbExpenseDetail);
        ExcelUtil<CbExpenseDetail> util = new ExcelUtil<CbExpenseDetail>(CbExpenseDetail.class);
        util.exportExcel(response, list, "费用明细数据");
    }

    /**
     * 获取费用明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbExpenseDetailService.selectCbExpenseDetailById(id));
    }

    /**
     * 新增费用明细
     */
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:add')")
    @Log(title = "费用明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbExpenseDetail cbExpenseDetail)
    {
        return toAjax(cbExpenseDetailService.insertCbExpenseDetail(cbExpenseDetail));
    }

    /**
     * 修改费用明细
     */
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:edit')")
    @Log(title = "费用明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbExpenseDetail cbExpenseDetail)
    {
        return toAjax(cbExpenseDetailService.updateCbExpenseDetail(cbExpenseDetail));
    }

    /**
     * 删除费用明细
     */
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:remove')")
    @Log(title = "费用明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbExpenseDetailService.deleteCbExpenseDetailByIds(ids));
    }


    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbExpenseDetail:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbExpenseDetail> util = new ExcelUtil<CbExpenseDetail>(CbExpenseDetail.class);
        List<CbExpenseDetail> cbEdList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbExpenseDetailService.importCbExpenseDetail(cbEdList, updateSupport, operName);
        return success(message);
    }


    @Log(title = "模板下载", businessType = BusinessType.TEMPLATE_DOWNLOAD)
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbExpenseDetail> util = new ExcelUtil<CbExpenseDetail>(CbExpenseDetail.class);
        util.importTemplateExcel(response, "费用明细数据");
    }
}
