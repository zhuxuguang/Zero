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
import com.zero.system.cb.domain.CbDeprecition;
import com.zero.system.cb.service.ICbDeprecitionService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 折旧Controller
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
@RestController
@RequestMapping("/system/cb/cbDeprecition")
public class CbDeprecitionController extends BaseController
{
    @Autowired
    private ICbDeprecitionService cbDeprecitionService;

    /**
     * 查询折旧列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:list')")
    @PostMapping("/list")
    public TableDataInfo list(CbDeprecition cbDeprecition)
    {
        startPage();
        List<CbDeprecition> list = cbDeprecitionService.selectCbDeprecitionList(cbDeprecition);
        return getDataTable(list);
    }

    /**
     * 导出折旧列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:export')")
    @Log(title = "折旧", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbDeprecition cbDeprecition)
    {
        List<CbDeprecition> list = cbDeprecitionService.selectCbDeprecitionList(cbDeprecition);
        ExcelUtil<CbDeprecition> util = new ExcelUtil<CbDeprecition>(CbDeprecition.class);
        util.exportExcel(response, list, "折旧数据");
    }

    /**
     * 获取折旧详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbDeprecitionService.selectCbDeprecitionById(id));
    }

    /**
     * 新增折旧
     */
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:add')")
    @Log(title = "折旧", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbDeprecition cbDeprecition)
    {
        return toAjax(cbDeprecitionService.insertCbDeprecition(cbDeprecition));
    }

    /**
     * 修改折旧
     */
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:edit')")
    @Log(title = "折旧", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbDeprecition cbDeprecition)
    {
        return toAjax(cbDeprecitionService.updateCbDeprecition(cbDeprecition));
    }

    /**
     * 删除折旧
     */
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:remove')")
    @Log(title = "折旧", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbDeprecitionService.deleteCbDeprecitionByIds(ids));
    }

    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbDeprecition:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbDeprecition> util = new ExcelUtil<CbDeprecition>(CbDeprecition.class);
        List<CbDeprecition> cbDtList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbDeprecitionService.importCbDeprecition(cbDtList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbDeprecition> util = new ExcelUtil<CbDeprecition>(CbDeprecition.class);
        util.importTemplateExcel(response, "折旧数据");
    }


}
