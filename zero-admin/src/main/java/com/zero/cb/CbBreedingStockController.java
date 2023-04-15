package com.zero.cb;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.system.cb.domain.CbArtificial;
import com.zero.system.service.ISysDeptService;
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
import com.zero.system.cb.domain.CbBreedingStock;
import com.zero.system.cb.service.ICbBreedingStockService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 存栏情况Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-30
 */
@RestController
@RequestMapping("/system/cb/cbBreedingStock")
public class CbBreedingStockController extends BaseController
{
    @Autowired
    private ICbBreedingStockService cbBreedingStockService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询存栏情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbBreedingStock:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbBreedingStock cbBreedingStock)
    {
        startPage();
        List<CbBreedingStock> list = cbBreedingStockService.selectCbBreedingStockList(cbBreedingStock);
        return getDataTable(list);
    }

    /**
     * 导出存栏情况列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbBreedingStock:export')")
    @Log(title = "存栏情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbBreedingStock cbBreedingStock)
    {
        List<CbBreedingStock> list = cbBreedingStockService.selectCbBreedingStockList(cbBreedingStock);
        ExcelUtil<CbBreedingStock> util = new ExcelUtil<CbBreedingStock>(CbBreedingStock.class);
        util.exportExcel(response, list, "存栏情况数据");
    }

    /**
     * 获取存栏情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbBreedingStock:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbBreedingStockService.selectCbBreedingStockById(id));
    }

    /**
     * 新增存栏情况
     */
    @PreAuthorize("@ss.hasPermi('system:cbBreedingStock:add')")
    @Log(title = "存栏情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbBreedingStock cbBreedingStock)
    {
        //组织名称
        SysDept dept = deptService.selectDeptById(cbBreedingStock.getHoggeryId());
        cbBreedingStock.setHoggeryName(dept.getDeptName());
        return toAjax(cbBreedingStockService.insertCbBreedingStock(cbBreedingStock));
    }

    /**
     * 修改存栏情况
     */
    @PreAuthorize("@ss.hasPermi('system:cbBreedingStock:edit')")
    @Log(title = "存栏情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbBreedingStock cbBreedingStock)
    {
        return toAjax(cbBreedingStockService.updateCbBreedingStock(cbBreedingStock));
    }

    /**
     * 删除存栏情况
     */
    @PreAuthorize("@ss.hasPermi('system:cbBreedingStock:remove')")
    @Log(title = "存栏情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbBreedingStockService.deleteCbBreedingStockByIds(ids));
    }

    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:CbBreedingStock:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbBreedingStock> util = new ExcelUtil<CbBreedingStock>(CbBreedingStock.class);
        List<CbBreedingStock> cbBsList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbBreedingStockService.importCbBreedingStock(cbBsList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbBreedingStock> util = new ExcelUtil<CbBreedingStock>(CbBreedingStock.class);
        util.importTemplateExcel(response, "存栏数据");
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:CbBreedingStock:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }
}
