package com.zero.k3cloud.k3Organization;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.system.k3cloud.k3Organization.domain.K3Organization;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationService;
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
import com.zero.system.k3cloud.k3Organization.domain.K3OrganizationMap;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationMapService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 组织间映射Controller
 * 
 * @author zhuxuguang
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/system/k3cloud/k3OrganizationMap")
public class K3OrganizationMapController extends BaseController
{
    @Autowired
    private IK3OrganizationMapService k3OrganizationMapService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IK3OrganizationService k3OrganizationService;
    /**
     * 查询组织间映射列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:list')")
    @GetMapping("/list")
    public TableDataInfo list(K3OrganizationMap k3OrganizationMap)
    {
        startPage();
        List<K3OrganizationMap> list = k3OrganizationMapService.selectK3OrganizationMapList(k3OrganizationMap);
        return getDataTable(list);
    }

    /**
     * 导出组织间映射列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:export')")
    @Log(title = "组织间映射", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, K3OrganizationMap k3OrganizationMap)
    {
        List<K3OrganizationMap> list = k3OrganizationMapService.selectK3OrganizationMapList(k3OrganizationMap);
        ExcelUtil<K3OrganizationMap> util = new ExcelUtil<K3OrganizationMap>(K3OrganizationMap.class);
        util.exportExcel(response, list, "组织间映射数据");
    }

    /**
     * 获取组织间映射详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax = AjaxResult.success();
        List<K3Organization> k3Organizations = k3OrganizationService.selectK3OrganizationAll();
        ajax.put("k3Organizations", k3Organizations);
        K3OrganizationMap k3OrganizationMap = k3OrganizationMapService.selectK3OrganizationMapById(id);
        ajax.put(AjaxResult.DATA_TAG, k3OrganizationMapService.selectK3OrganizationMapById(id));
        ajax.put("k3Forgid", k3OrganizationService.selectK3OrganizationByForgid(Long.parseLong(k3OrganizationMap.getK3Forgid())));
        return ajax;
    }

    /**
     * 新增组织间映射
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:add')")
    @Log(title = "组织间映射", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody K3OrganizationMap k3OrganizationMap)
    {
        return toAjax(k3OrganizationMapService.insertK3OrganizationMap(k3OrganizationMap));
    }

    /**
     * 修改组织间映射
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:edit')")
    @Log(title = "组织间映射", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody K3OrganizationMap k3OrganizationMap)
    {
        return toAjax(k3OrganizationMapService.updateK3OrganizationMap(k3OrganizationMap));
    }

    /**
     * 删除组织间映射
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:remove')")
    @Log(title = "组织间映射", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(k3OrganizationMapService.deleteK3OrganizationMapByIds(ids));
    }

    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept)
    {
        return success(deptService.selectDeptTreeList(dept));
    }

    /**
     * 获取第三方部门信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:k3OrganizationMap:list')")
    @GetMapping("/k3OrganizationSelect")
    public AjaxResult k3OrganizationSelect()
    {
        AjaxResult ajax = AjaxResult.success();
        List<K3Organization> k3Organizations = k3OrganizationService.selectK3OrganizationAll();
        ajax.put("k3Organizations", k3Organizations);
        return ajax;
    }
}
