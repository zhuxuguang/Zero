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
import com.zero.system.cb.domain.CbFeedingFirstDay;
import com.zero.system.cb.service.ICbFeedingFirstDayService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 饲养头日Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-31
 */
@RestController
@RequestMapping("/system/cb/cbFeedingFirstDay")
public class CbFeedingFirstDayController extends BaseController
{
    @Autowired
    private ICbFeedingFirstDayService cbFeedingFirstDayService;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询饲养头日列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbFeedingFirstDay cbFeedingFirstDay)
    {
        startPage();
        List<CbFeedingFirstDay> list = cbFeedingFirstDayService.selectCbFeedingFirstDayList(cbFeedingFirstDay);
        return getDataTable(list);
    }

    /**
     * 导出饲养头日列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:export')")
    @Log(title = "饲养头日", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbFeedingFirstDay cbFeedingFirstDay)
    {
        List<CbFeedingFirstDay> list = cbFeedingFirstDayService.selectCbFeedingFirstDayList(cbFeedingFirstDay);
        ExcelUtil<CbFeedingFirstDay> util = new ExcelUtil<CbFeedingFirstDay>(CbFeedingFirstDay.class);
        util.exportExcel(response, list, "饲养头日数据");
    }

    /**
     * 获取饲养头日详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbFeedingFirstDayService.selectCbFeedingFirstDayById(id));
    }

    /**
     * 新增饲养头日
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:add')")
    @Log(title = "饲养头日", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbFeedingFirstDay cbFeedingFirstDay)
    {
        return toAjax(cbFeedingFirstDayService.insertCbFeedingFirstDay(cbFeedingFirstDay));
    }

    /**
     * 修改饲养头日
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:edit')")
    @Log(title = "饲养头日", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbFeedingFirstDay cbFeedingFirstDay)
    {
        return toAjax(cbFeedingFirstDayService.updateCbFeedingFirstDay(cbFeedingFirstDay));
    }

    /**
     * 删除饲养头日
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:remove')")
    @Log(title = "饲养头日", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbFeedingFirstDayService.deleteCbFeedingFirstDayByIds(ids));
    }

    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbFeedingFirstDay> util = new ExcelUtil<CbFeedingFirstDay>(CbFeedingFirstDay.class);
        List<CbFeedingFirstDay> cbFFList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbFeedingFirstDayService.importCbFeedingFirstDay(cbFFList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbFeedingFirstDay> util = new ExcelUtil<CbFeedingFirstDay>(CbFeedingFirstDay.class);
        util.importTemplateExcel(response, "饲养头日数据");
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFeedingFirstDay:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }
}
