package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbFileOfMaterials;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 物料档案Service接口
 * 
 * @author zhuxuguang
 * @date 2023-01-18
 */
public interface ICbFileOfMaterialsService 
{
    /**
     * 查询物料档案
     * 
     * @param id 物料档案主键
     * @return 物料档案
     */
    public CbFileOfMaterials selectCbFileOfMaterialsById(Long id);

    /**
     * 查询物料档案列表
     * 
     * @param cbFileOfMaterials 物料档案
     * @return 物料档案集合
     */
    public List<CbFileOfMaterials> selectCbFileOfMaterialsList(CbFileOfMaterials cbFileOfMaterials);

    /**
     * 新增物料档案
     * 
     * @param cbFileOfMaterials 物料档案
     * @return 结果
     */
    public int insertCbFileOfMaterials(CbFileOfMaterials cbFileOfMaterials);

    /**
     * 修改物料档案
     * 
     * @param cbFileOfMaterials 物料档案
     * @return 结果
     */
    public int updateCbFileOfMaterials(CbFileOfMaterials cbFileOfMaterials);

    /**
     * 批量删除物料档案
     * 
     * @param ids 需要删除的物料档案主键集合
     * @return 结果
     */
    public int deleteCbFileOfMaterialsByIds(Long[] ids);

    /**
     * 删除物料档案信息
     * 
     * @param id 物料档案主键
     * @return 结果
     */
    public int deleteCbFileOfMaterialsById(Long id);


    /**
     * 导入物料档案数据
     *
     * @param cbFMList 物料档案数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbFileOfMaterials(List<CbFileOfMaterials> cbFMList, Boolean isUpdateSupport, String operName);


    /**
     * 查询物料档案
     *
     * @param materialCoding 物料档案物料编码
     * @return 物料档案
     */
    public CbFileOfMaterials selectCbFileOfMaterialsByMaterialCoding(String materialCoding);
}
