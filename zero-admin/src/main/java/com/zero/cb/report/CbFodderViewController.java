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
import com.zero.system.cb.report.domain.CbFodderView;
import com.zero.system.cb.report.service.ICbFodderViewService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 饲料详情报表Controller
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@RestController
@RequestMapping("/system/cb/report/cbFodderView")
public class CbFodderViewController extends BaseController
{
    @Autowired
    private ICbFodderViewService cbFodderViewService;

    /**
     * 查询饲料详情报表列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFodderView:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbFodderView cbFodderView)
    {
        startPage();
        List<CbFodderView> list = cbFodderViewService.selectCbFodderViewList(cbFodderView);
        return getDataTable(list);
    }

    /**
     * 导出饲料详情报表列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFodderView:export')")
    @Log(title = "饲料详情报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbFodderView cbFodderView)
    {
        List<CbFodderView> list = cbFodderViewService.selectCbFodderViewList(cbFodderView);
        ExcelUtil<CbFodderView> util = new ExcelUtil<CbFodderView>(CbFodderView.class);
        util.exportExcel(response, list, "饲料详情报表数据");
    }

    /**
     * 获取饲料详情报表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbFodderView:query')")
    @GetMapping(value = "/{type}")
    public AjaxResult getInfo(@PathVariable("type") String type)
    {
        return success(cbFodderViewService.selectCbFodderViewByType(type));
    }

    /**
     * 新增饲料详情报表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFodderView:add')")
    @Log(title = "饲料详情报表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbFodderView cbFodderView)
    {
        return toAjax(cbFodderViewService.insertCbFodderView(cbFodderView));
    }

    /**
     * 修改饲料详情报表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFodderView:edit')")
    @Log(title = "饲料详情报表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbFodderView cbFodderView)
    {
        return toAjax(cbFodderViewService.updateCbFodderView(cbFodderView));
    }

    /**
     * 删除饲料详情报表
     */
    @PreAuthorize("@ss.hasPermi('system:cbFodderView:remove')")
    @Log(title = "饲料详情报表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{types}")
    public AjaxResult remove(@PathVariable String[] types)
    {
        return toAjax(cbFodderViewService.deleteCbFodderViewByTypes(types));
    }
}
