package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbProductionMaterial;

/**
 * 生产领料Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
public interface CbProductionMaterialMapper 
{
    /**
     * 查询生产领料
     * 
     * @param id 生产领料主键
     * @return 生产领料
     */
    public CbProductionMaterial selectCbProductionMaterialById(Long id);

    /**
     * 查询生产领料列表
     * 
     * @param cbProductionMaterial 生产领料
     * @return 生产领料集合
     */
    public List<CbProductionMaterial> selectCbProductionMaterialList(CbProductionMaterial cbProductionMaterial);

    /**
     * 新增生产领料
     * 
     * @param cbProductionMaterial 生产领料
     * @return 结果
     */
    public int insertCbProductionMaterial(CbProductionMaterial cbProductionMaterial);

    /**
     * 修改生产领料
     * 
     * @param cbProductionMaterial 生产领料
     * @return 结果
     */
    public int updateCbProductionMaterial(CbProductionMaterial cbProductionMaterial);

    /**
     * 删除生产领料
     * 
     * @param id 生产领料主键
     * @return 结果
     */
    public int deleteCbProductionMaterialById(Long id);

    /**
     * 批量删除生产领料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbProductionMaterialByIds(Long[] ids);

    /**
     * 批量插入
     * @param cbProductionMaterial
     * @return
     */
    int saveInfo(CbProductionMaterial cbProductionMaterial);
}
