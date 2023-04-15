package com.zero.cb;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.common.core.domain.entity.SysUser;
import com.zero.system.cb.domain.CbProductionMaterial;
import com.zero.system.service.ISysDeptService;
import io.swagger.annotations.Api;
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
import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.cb.service.ICbProductionTargetService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 生产目标Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
@RestController
@RequestMapping("/system/cb/cbProductionTarget")
@Api
public class CbProductionTargetController extends BaseController
{
    @Autowired
    private ICbProductionTargetService cbProductionTargetService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询生产目标列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbProductionTarget cbProductionTarget)
    {
        startPage();
        List<CbProductionTarget> list = cbProductionTargetService.selectCbProductionTargetList(cbProductionTarget);
        return getDataTable(list);
    }

    /**
     * 导出生产目标列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:export')")
    @Log(title = "生产目标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbProductionTarget cbProductionTarget)
    {
        List<CbProductionTarget> list = cbProductionTargetService.selectCbProductionTargetList(cbProductionTarget);
        ExcelUtil<CbProductionTarget> util = new ExcelUtil<CbProductionTarget>(CbProductionTarget.class);
        util.exportExcel(response, list, "生产目标数据");
    }

    /**
     * 获取生产目标详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbProductionTargetService.selectCbProductionTargetById(id));
    }

    /**
     * 新增生产目标
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:add')")
    @Log(title = "生产目标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbProductionTarget cbProductionTarget)
    {
        return toAjax(cbProductionTargetService.insertCbProductionTarget(cbProductionTarget));
    }

    /**
     * 修改生产目标
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:edit')")
    @Log(title = "生产目标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbProductionTarget cbProductionTarget)
    {
        return toAjax(cbProductionTargetService.updateCbProductionTarget(cbProductionTarget));
    }

    /**
     * 删除生产目标
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:remove')")
    @Log(title = "生产目标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbProductionTargetService.deleteCbProductionTargetByIds(ids));
    }


    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbProductionTarget> util = new ExcelUtil<CbProductionTarget>(CbProductionTarget.class);
        List<CbProductionTarget> cbPtList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbProductionTargetService.importCbProductionTarget(cbPtList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbProductionTarget> util = new ExcelUtil<CbProductionTarget>(CbProductionTarget.class);
        util.importTemplateExcel(response, "生产目标数据");
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionTarget:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }
}
