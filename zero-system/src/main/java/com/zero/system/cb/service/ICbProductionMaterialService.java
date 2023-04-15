package com.zero.system.cb.service;

import java.text.ParseException;
import java.util.List;
import com.zero.system.cb.domain.CbProductionMaterial;
import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;

/**
 * 生产领料Service接口
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
public interface ICbProductionMaterialService 
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
     * 批量删除生产领料
     * 
     * @param ids 需要删除的生产领料主键集合
     * @return 结果
     */
    public int deleteCbProductionMaterialByIds(Long[] ids);

    /**
     * 删除生产领料信息
     * 
     * @param id 生产领料主键
     * @return 结果
     */
    public int deleteCbProductionMaterialById(Long id);


    /**
     * 导入生产目标数据
     *
     * @param cbPmList 生产目标数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbProductionMaterial(List<CbProductionMaterial> cbPmList, Boolean isUpdateSupport, String operName);

    /**
     * 合并第三方单据信息
     * @param k3SpPickmtrlList
     * @return
     */
    public String mergeCbProductionMaterial(List<K3SpPickmtrl> k3SpPickmtrlList) throws ParseException;
}
