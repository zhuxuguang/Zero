package com.zero.system.k3cloud.k3Material.service;

import java.util.List;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialbase;
import org.apache.ibatis.annotations.Param;

/**
 * 存储物料信息Service接口
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
public interface IK3BdMaterialbaseService 
{
    /**
     * 查询存储物料信息
     * 
     * @param id 存储物料信息主键
     * @return 存储物料信息
     */
    public K3BdMaterialbase selectK3BdMaterialbaseById(Long id);

    /**
     * 查询存储物料信息列表
     * 
     * @param k3BdMaterialbase 存储物料信息
     * @return 存储物料信息集合
     */
    public List<K3BdMaterialbase> selectK3BdMaterialbaseList(K3BdMaterialbase k3BdMaterialbase);

    /**
     * 新增存储物料信息
     * 
     * @param k3BdMaterialbase 存储物料信息
     * @return 结果
     */
    public int insertK3BdMaterialbase(K3BdMaterialbase k3BdMaterialbase);

    /**
     * 修改存储物料信息
     * 
     * @param k3BdMaterialbase 存储物料信息
     * @return 结果
     */
    public int updateK3BdMaterialbase(K3BdMaterialbase k3BdMaterialbase);

    /**
     * 批量删除存储物料信息
     * 
     * @param ids 需要删除的存储物料信息主键集合
     * @return 结果
     */
    public int deleteK3BdMaterialbaseByIds(Long[] ids);

    /**
     * 删除存储物料信息信息
     * 
     * @param id 存储物料信息主键
     * @return 结果
     */
    public int deleteK3BdMaterialbaseById(Long id);

    /**
     * 全部删除存储第三方物料类别信息信息
     *
     * @param
     * @return 结果
     */
    public int deleteK3BdMaterialbaseAll();


    /**
     * 批量插入
     * @param k3BdMaterialbaseList
     */
    void insertK3BdMaterialbaseAll(@Param("k3BdMaterialbaseList") List<K3BdMaterialbase> k3BdMaterialbaseList);

    /**
     * 使用sqlSessionFactory实现批量插入
     * @param list
     */
    void saveBeach(List<K3BdMaterialbase> list);

    /**
     * 查询存储物料信息
     *
     * @param fmaterialId 存储物料信息主键 物料内码
     * @return 存储物料信息
     */
    public K3BdMaterialbase selectK3BMById(Long fmaterialId);
}
