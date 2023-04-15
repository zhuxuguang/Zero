package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbFileOfMaterials;

/**
 * 物料档案Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-18
 */
public interface CbFileOfMaterialsMapper 
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
     * 删除物料档案
     * 
     * @param id 物料档案主键
     * @return 结果
     */
    public int deleteCbFileOfMaterialsById(Long id);

    /**
     * 批量删除物料档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbFileOfMaterialsByIds(Long[] ids);


    /**
     * 查询物料档案
     *
     * @param materialCoding 物料档案物料编码
     * @return 物料档案
     */
    public CbFileOfMaterials selectCbFileOfMaterialsByMaterialCoding(String materialCoding);
}
