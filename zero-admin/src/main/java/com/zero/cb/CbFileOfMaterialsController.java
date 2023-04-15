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
import com.zero.system.cb.domain.CbFileOfMaterials;
import com.zero.system.cb.service.ICbFileOfMaterialsService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 物料档案Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-18
 */
@RestController
@RequestMapping("/system/cb/cbFileOfMaterials")
public class CbFileOfMaterialsController extends BaseController
{
    @Autowired
    private ICbFileOfMaterialsService cbFileOfMaterialsService;

    /**
     * 查询物料档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbFileOfMaterials cbFileOfMaterials)
    {
        startPage();
        List<CbFileOfMaterials> list = cbFileOfMaterialsService.selectCbFileOfMaterialsList(cbFileOfMaterials);
        return getDataTable(list);
    }

    /**
     * 导出物料档案列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:export')")
    @Log(title = "物料档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbFileOfMaterials cbFileOfMaterials)
    {
        List<CbFileOfMaterials> list = cbFileOfMaterialsService.selectCbFileOfMaterialsList(cbFileOfMaterials);
        ExcelUtil<CbFileOfMaterials> util = new ExcelUtil<CbFileOfMaterials>(CbFileOfMaterials.class);
        util.exportExcel(response, list, "物料档案数据");
    }

    /**
     * 获取物料档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbFileOfMaterialsService.selectCbFileOfMaterialsById(id));
    }

    /**
     * 新增物料档案
     */
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:add')")
    @Log(title = "物料档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbFileOfMaterials cbFileOfMaterials)
    {
        return toAjax(cbFileOfMaterialsService.insertCbFileOfMaterials(cbFileOfMaterials));
    }

    /**
     * 修改物料档案
     */
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:edit')")
    @Log(title = "物料档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbFileOfMaterials cbFileOfMaterials)
    {
        return toAjax(cbFileOfMaterialsService.updateCbFileOfMaterials(cbFileOfMaterials));
    }

    /**
     * 删除物料档案
     */
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:remove')")
    @Log(title = "物料档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbFileOfMaterialsService.deleteCbFileOfMaterialsByIds(ids));
    }

    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbFileOfMaterials:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbFileOfMaterials> util = new ExcelUtil<CbFileOfMaterials>(CbFileOfMaterials.class);
        List<CbFileOfMaterials> cbFMList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbFileOfMaterialsService.importCbFileOfMaterials(cbFMList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbFileOfMaterials> util = new ExcelUtil<CbFileOfMaterials>(CbFileOfMaterials.class);
        util.importTemplateExcel(response, "物料档案数据");
    }
}
