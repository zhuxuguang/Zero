package com.zero.cb;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zero.common.core.domain.entity.SysUser;
import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;
import com.zero.system.k3cloud.k3Material.service.IK3SpPickmtrlService;
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
import com.zero.system.cb.domain.CbProductionMaterial;
import com.zero.system.cb.service.ICbProductionMaterialService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 生产领料Controller
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
@RestController
@RequestMapping("/system/cb/cbProductionMaterial")
public class CbProductionMaterialController extends BaseController
{
    @Autowired
    private ICbProductionMaterialService cbProductionMaterialService;

    //第三方简单生产领料单接口
    @Autowired
    private IK3SpPickmtrlService k3SpPickmtrlService;

    /**
     * 查询生产领料列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CbProductionMaterial cbProductionMaterial)
    {
        startPage();
        List<CbProductionMaterial> list = cbProductionMaterialService.selectCbProductionMaterialList(cbProductionMaterial);
        return getDataTable(list);
    }

    /**
     * 导出生产领料列表
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:export')")
    @Log(title = "生产领料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CbProductionMaterial cbProductionMaterial)
    {
        List<CbProductionMaterial> list = cbProductionMaterialService.selectCbProductionMaterialList(cbProductionMaterial);
        ExcelUtil<CbProductionMaterial> util = new ExcelUtil<CbProductionMaterial>(CbProductionMaterial.class);
        util.exportExcel(response, list, "生产领料数据");
    }

    /**
     * 获取生产领料详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cbProductionMaterialService.selectCbProductionMaterialById(id));
    }

    /**
     * 新增生产领料
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:add')")
    @Log(title = "生产领料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CbProductionMaterial cbProductionMaterial)
    {
        return toAjax(cbProductionMaterialService.insertCbProductionMaterial(cbProductionMaterial));
    }

    /**
     * 修改生产领料
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:edit')")
    @Log(title = "生产领料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CbProductionMaterial cbProductionMaterial)
    {
        return toAjax(cbProductionMaterialService.updateCbProductionMaterial(cbProductionMaterial));
    }

    /**
     * 删除生产领料
     */
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:remove')")
    @Log(title = "生产领料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cbProductionMaterialService.deleteCbProductionMaterialByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CbProductionMaterial> util = new ExcelUtil<CbProductionMaterial>(CbProductionMaterial.class);
        util.importTemplateExcel(response, "生产领料数据");
    }


    @Log(title = "数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CbProductionMaterial> util = new ExcelUtil<CbProductionMaterial>(CbProductionMaterial.class);
        List<CbProductionMaterial> cbPmList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cbProductionMaterialService.importCbProductionMaterial(cbPmList, updateSupport, operName);
        return success(message);
    }

    @Log(title = "数据合并", businessType = BusinessType.MERGE)
    @PreAuthorize("@ss.hasPermi('system:cbProductionMaterial:merge')")
    @PostMapping("/merge")
    public AjaxResult merge() throws ParseException {
        //查询第三方简单生产领料单
        List<K3SpPickmtrl> k3SpPickmtrlList = k3SpPickmtrlService.selectKmK3SPList();
        String message = cbProductionMaterialService.mergeCbProductionMaterial(k3SpPickmtrlList);
        return AjaxResult.success(message);
    }
}
