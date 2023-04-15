package com.zero.cb;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.system.cb.domain.CbProductionTarget;
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
import com.zero.system.cb.domain.CbArtificial;
import com.zero.system.cb.service.ICbArtificialService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人工Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-06
 */
@RestController
@RequestMapping("/system/cb/cbArtificial")
public class CbArtificialController extends BaseController
{
    @Autowired
    private ICbArtificialService cbArtificialService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询人工列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbArtificial cbArtificial)
    {
        startPage();
        List<CbArtificial> list = cbArtificialService.selectCbArtificialList(cbArtificial);
        return getDataTable(list);
    }

    /**
     * 导出人工列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:export')")
    @Log(title = "人工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbArtificial cbArtificial)
    {
        List<CbArtificial> list = cbArtificialService.selectCbArtificialList(cbArtificial);
        ExcelUtil<CbArtificial> util = new ExcelUtil<CbArtificial>(CbArtificial.class);
        util.exportExcel(response, list, "人工数据");
    }

    /**
     * 获取人工详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbArtificialService.selectCbArtificialById(id));
    }

    /**
     * 新增人工
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:add')")
    @Log(title = "人工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbArtificial cbArtificial)
    {
        return toAjax(cbArtificialService.insertCbArtificial(cbArtificial));
    }

    /**
     * 修改人工
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:edit')")
    @Log(title = "人工", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbArtificial cbArtificial)
    {
        return toAjax(cbArtificialService.updateCbArtificial(cbArtificial));
    }

    /**
     * 删除人工
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:remove')")
    @Log(title = "人工", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbArtificialService.deleteCbArtificialByIds(ids));
    }


    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbArtificial> util = new ExcelUtil<CbArtificial>(CbArtificial.class);
        List<CbArtificial> cbAList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbArtificialService.importCbArtificial(cbAList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbArtificial> util = new ExcelUtil<CbArtificial>(CbArtificial.class);
        util.importTemplateExcel(response, "人工数据");
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbArtificial:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }
}
