package com.zero.system.k3cloud.k3Material.service;

import java.util.List;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialcategory;

/**
 * 存储第三方物料类别信息Service接口
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
public interface IK3BdMaterialcategoryService 
{
    /**
     * 查询存储第三方物料类别信息
     * 
     * @param id 存储第三方物料类别信息主键
     * @return 存储第三方物料类别信息
     */
    public K3BdMaterialcategory selectK3BdMaterialcategoryById(Long id);

    /**
     * 查询存储第三方物料类别信息列表
     * 
     * @param k3BdMaterialcategory 存储第三方物料类别信息
     * @return 存储第三方物料类别信息集合
     */
    public List<K3BdMaterialcategory> selectK3BdMaterialcategoryList(K3BdMaterialcategory k3BdMaterialcategory);

    /**
     * 新增存储第三方物料类别信息
     * 
     * @param k3BdMaterialcategory 存储第三方物料类别信息
     * @return 结果
     */
    public int insertK3BdMaterialcategory(K3BdMaterialcategory k3BdMaterialcategory);

    /**
     * 修改存储第三方物料类别信息
     * 
     * @param k3BdMaterialcategory 存储第三方物料类别信息
     * @return 结果
     */
    public int updateK3BdMaterialcategory(K3BdMaterialcategory k3BdMaterialcategory);

    /**
     * 批量删除存储第三方物料类别信息
     * 
     * @param ids 需要删除的存储第三方物料类别信息主键集合
     * @return 结果
     */
    public int deleteK3BdMaterialcategoryByIds(Long[] ids);

    /**
     * 删除存储第三方物料类别信息信息
     * 
     * @param id 存储第三方物料类别信息主键
     * @return 结果
     */
    public int deleteK3BdMaterialcategoryById(Long id);

    /**
     * 全部删除存储第三方物料类别信息信息
     *
     * @param
     * @return 结果
     */
    public int deleteK3BdMaterialcategoryAll();


    /**
     * 查询存储第三方物料类别信息
     *
     * @param fcategoryId 存储第三方物料类别信息内码
     * @return 存储第三方物料类别信息
     */
    public K3BdMaterialcategory selectK3BdMaterialcategoryByCgId(Long fcategoryId);
}
