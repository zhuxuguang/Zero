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
import com.zero.system.cb.domain.CbSynthetical;
import com.zero.system.cb.service.ICbSyntheticalService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 其他数据Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-21
 */
@RestController
@RequestMapping("/system/cb/cbSynthetical")
public class CbSyntheticalController extends BaseController
{
    @Autowired
    private ICbSyntheticalService cbSyntheticalService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询其他数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbSynthetical cbSynthetical)
    {
        startPage();
        List<CbSynthetical> list = cbSyntheticalService.selectCbSyntheticalList(cbSynthetical);
        return getDataTable(list);
    }

    /**
     * 导出其他数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:export')")
    @Log(title = "其他数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbSynthetical cbSynthetical)
    {
        List<CbSynthetical> list = cbSyntheticalService.selectCbSyntheticalList(cbSynthetical);
        ExcelUtil<CbSynthetical> util = new ExcelUtil<CbSynthetical>(CbSynthetical.class);
        util.exportExcel(response, list, "其他数据数据");
    }

    /**
     * 获取其他数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbSyntheticalService.selectCbSyntheticalById(id));
    }

    /**
     * 新增其他数据
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:add')")
    @Log(title = "其他数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbSynthetical cbSynthetical)
    {
        //组织名称
        SysDept dept = deptService.selectDeptById(cbSynthetical.getHoggeryId());
        cbSynthetical.setHoggeryName(dept.getDeptName());
        return toAjax(cbSyntheticalService.insertCbSynthetical(cbSynthetical));
    }

    /**
     * 修改其他数据
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:edit')")
    @Log(title = "其他数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbSynthetical cbSynthetical)
    {
        return toAjax(cbSyntheticalService.updateCbSynthetical(cbSynthetical));
    }

    /**
     * 删除其他数据
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:remove')")
    @Log(title = "其他数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbSyntheticalService.deleteCbSyntheticalByIds(ids));
    }

    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbSynthetical> util = new ExcelUtil<CbSynthetical>(CbSynthetical.class);
        List<CbSynthetical> cbSList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbSyntheticalService.importCbSyntheticalTarget(cbSList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbSynthetical> util = new ExcelUtil<CbSynthetical>(CbSynthetical.class);
        util.importTemplateExcel(response, "生产目标数据");
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbSynthetical:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }

}
