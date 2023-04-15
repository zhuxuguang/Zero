package com.zero.system.k3cloud.k3Material.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.k3cloud.k3Material.mapper.K3BdMaterialcategoryMapper;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialcategory;
import com.zero.system.k3cloud.k3Material.service.IK3BdMaterialcategoryService;

/**
 * 存储第三方物料类别信息Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
@Service
public class K3BdMaterialcategoryServiceImpl implements IK3BdMaterialcategoryService 
{
    @Autowired
    private K3BdMaterialcategoryMapper k3BdMaterialcategoryMapper;

    /**
     * 查询存储第三方物料类别信息
     * 
     * @param id 存储第三方物料类别信息主键
     * @return 存储第三方物料类别信息
     */
    @Override
    public K3BdMaterialcategory selectK3BdMaterialcategoryById(Long id)
    {
        return k3BdMaterialcategoryMapper.selectK3BdMaterialcategoryById(id);
    }

    /**
     * 查询存储第三方物料类别信息列表
     * 
     * @param k3BdMaterialcategory 存储第三方物料类别信息
     * @return 存储第三方物料类别信息
     */
    @Override
    public List<K3BdMaterialcategory> selectK3BdMaterialcategoryList(K3BdMaterialcategory k3BdMaterialcategory)
    {
        return k3BdMaterialcategoryMapper.selectK3BdMaterialcategoryList(k3BdMaterialcategory);
    }

    /**
     * 新增存储第三方物料类别信息
     * 
     * @param k3BdMaterialcategory 存储第三方物料类别信息
     * @return 结果
     */
    @Override
    public int insertK3BdMaterialcategory(K3BdMaterialcategory k3BdMaterialcategory)
    {
        k3BdMaterialcategory.setCreateTime(DateUtils.getNowDate());
        return k3BdMaterialcategoryMapper.insertK3BdMaterialcategory(k3BdMaterialcategory);
    }

    /**
     * 修改存储第三方物料类别信息
     * 
     * @param k3BdMaterialcategory 存储第三方物料类别信息
     * @return 结果
     */
    @Override
    public int updateK3BdMaterialcategory(K3BdMaterialcategory k3BdMaterialcategory)
    {
        k3BdMaterialcategory.setUpdateTime(DateUtils.getNowDate());
        return k3BdMaterialcategoryMapper.updateK3BdMaterialcategory(k3BdMaterialcategory);
    }

    /**
     * 批量删除存储第三方物料类别信息
     * 
     * @param ids 需要删除的存储第三方物料类别信息主键
     * @return 结果
     */
    @Override
    public int deleteK3BdMaterialcategoryByIds(Long[] ids)
    {
        return k3BdMaterialcategoryMapper.deleteK3BdMaterialcategoryByIds(ids);
    }

    /**
     * 删除存储第三方物料类别信息信息
     * 
     * @param id 存储第三方物料类别信息主键
     * @return 结果
     */
    @Override
    public int deleteK3BdMaterialcategoryById(Long id)
    {
        return k3BdMaterialcategoryMapper.deleteK3BdMaterialcategoryById(id);
    }

    /**
     * 全部删除存储第三方物料类别信息信息
     *
     * @return 结果
     */
    @Override
    public int deleteK3BdMaterialcategoryAll() {
        return k3BdMaterialcategoryMapper.deleteK3BdMaterialcategoryAll();
    }

    /**
     * 查询存储第三方物料类别信息
     *
     * @param fcategoryId 存储第三方物料类别信息内码
     * @return 存储第三方物料类别信息
     */
    @Override
    public K3BdMaterialcategory selectK3BdMaterialcategoryByCgId(Long fcategoryId) {
        return k3BdMaterialcategoryMapper.selectK3BdMaterialcategoryByCgId(fcategoryId);
    }


}
