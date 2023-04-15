package com.zero.web.controller.system;

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
import com.zero.system.domain.SysSpecialConfig;
import com.zero.system.service.ISysSpecialConfigService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 专项参数配置Controller
 * 
 * @author zhuxuguang
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/system/sysSpecialConfig")
public class SysSpecialConfigController extends BaseController
{
    @Autowired
    private ISysSpecialConfigService sysSpecialConfigService;

    /**
     * 查询专项参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:sysSpecialConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSpecialConfig sysSpecialConfig)
    {
        startPage();
        List<SysSpecialConfig> list = sysSpecialConfigService.selectSysSpecialConfigList(sysSpecialConfig);
        return getDataTable(list);
    }

    /**
     * 导出专项参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:sysSpecialConfig:export')")
    @Log(title = "专项参数配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysSpecialConfig sysSpecialConfig)
    {
        List<SysSpecialConfig> list = sysSpecialConfigService.selectSysSpecialConfigList(sysSpecialConfig);
        ExcelUtil<SysSpecialConfig> util = new ExcelUtil<SysSpecialConfig>(SysSpecialConfig.class);
        util.exportExcel(response, list, "专项参数配置数据");
    }

    /**
     * 获取专项参数配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sysSpecialConfig:query')")
    @GetMapping(value = "/{configId}")
    public AjaxResult getInfo(@PathVariable("configId") Long configId)
    {
        return success(sysSpecialConfigService.selectSysSpecialConfigByConfigId(configId));
    }

    /**
     * 新增专项参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:sysSpecialConfig:add')")
    @Log(title = "专项参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSpecialConfig sysSpecialConfig)
    {
        return toAjax(sysSpecialConfigService.insertSysSpecialConfig(sysSpecialConfig));
    }

    /**
     * 修改专项参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:sysSpecialConfig:edit')")
    @Log(title = "专项参数配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSpecialConfig sysSpecialConfig)
    {
        return toAjax(sysSpecialConfigService.updateSysSpecialConfig(sysSpecialConfig));
    }

    /**
     * 删除专项参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:sysSpecialConfig:remove')")
    @Log(title = "专项参数配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{configIds}")
    public AjaxResult remove(@PathVariable Long[] configIds)
    {
        return toAjax(sysSpecialConfigService.deleteSysSpecialConfigByConfigIds(configIds));
    }
}
