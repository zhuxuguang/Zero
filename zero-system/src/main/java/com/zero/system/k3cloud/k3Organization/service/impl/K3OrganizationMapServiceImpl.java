package com.zero.system.k3cloud.k3Organization.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.k3cloud.k3Organization.mapper.K3OrganizationMapMapper;
import com.zero.system.k3cloud.k3Organization.domain.K3OrganizationMap;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationMapService;

/**
 * 组织间映射Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-04-05
 */
@Service
public class K3OrganizationMapServiceImpl implements IK3OrganizationMapService 
{
    @Autowired
    private K3OrganizationMapMapper k3OrganizationMapMapper;

    /**
     * 查询组织间映射
     * 
     * @param id 组织间映射主键
     * @return 组织间映射
     */
    @Override
    public K3OrganizationMap selectK3OrganizationMapById(Long id)
    {
        return k3OrganizationMapMapper.selectK3OrganizationMapById(id);
    }

    /**
     * 查询组织间映射列表
     * 
     * @param k3OrganizationMap 组织间映射
     * @return 组织间映射
     */
    @Override
    public List<K3OrganizationMap> selectK3OrganizationMapList(K3OrganizationMap k3OrganizationMap)
    {
        return k3OrganizationMapMapper.selectK3OrganizationMapList(k3OrganizationMap);
    }

    /**
     * 新增组织间映射
     * 
     * @param k3OrganizationMap 组织间映射
     * @return 结果
     */
    @Override
    public int insertK3OrganizationMap(K3OrganizationMap k3OrganizationMap)
    {
        k3OrganizationMap.setCreateBy(SecurityUtils.getUsername());
        k3OrganizationMap.setCreateTime(DateUtils.getNowDate());
        return k3OrganizationMapMapper.insertK3OrganizationMap(k3OrganizationMap);
    }

    /**
     * 修改组织间映射
     * 
     * @param k3OrganizationMap 组织间映射
     * @return 结果
     */
    @Override
    public int updateK3OrganizationMap(K3OrganizationMap k3OrganizationMap)
    {
        k3OrganizationMap.setUpdateBy(SecurityUtils.getUsername());
        k3OrganizationMap.setUpdateTime(DateUtils.getNowDate());
        return k3OrganizationMapMapper.updateK3OrganizationMap(k3OrganizationMap);
    }

    /**
     * 批量删除组织间映射
     * 
     * @param ids 需要删除的组织间映射主键
     * @return 结果
     */
    @Override
    public int deleteK3OrganizationMapByIds(Long[] ids)
    {
        return k3OrganizationMapMapper.deleteK3OrganizationMapByIds(ids);
    }

    /**
     * 删除组织间映射信息
     * 
     * @param id 组织间映射主键
     * @return 结果
     */
    @Override
    public int deleteK3OrganizationMapById(Long id)
    {
        return k3OrganizationMapMapper.deleteK3OrganizationMapById(id);
    }

    /**
     * 查询所以映射组织信息
     *
     * @return
     */
    @Override
    public List<K3OrganizationMap> selectK3OrganizationMapAll() {
        return k3OrganizationMapMapper.selectK3OrganizationMapAll();
    }

    /**
     * 查询组织间映射
     *
     * @param k3Forgid 组织间映射主键 - 第三方组织内码
     * @return 组织间映射
     */
    @Override
    public K3OrganizationMap selectK3OMByk3Forgid(String k3Forgid) {
        return k3OrganizationMapMapper.selectK3OMByk3Forgid(k3Forgid);
    }
}
