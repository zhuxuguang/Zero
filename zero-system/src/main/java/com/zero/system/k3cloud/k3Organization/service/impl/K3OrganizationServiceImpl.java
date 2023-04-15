package com.zero.system.k3cloud.k3Organization.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.k3cloud.k3Organization.mapper.K3OrganizationMapper;
import com.zero.system.k3cloud.k3Organization.domain.K3Organization;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationService;

/**
 * 存储第三方组织信息Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
@Service
public class K3OrganizationServiceImpl implements IK3OrganizationService 
{
    @Autowired
    private K3OrganizationMapper k3OrganizationMapper;

    /**
     * 查询存储第三方组织信息
     * 
     * @param id 存储第三方组织信息主键
     * @return 存储第三方组织信息
     */
    @Override
    public K3Organization selectK3OrganizationById(Long id)
    {
        return k3OrganizationMapper.selectK3OrganizationById(id);
    }

    /**
     * 查询存储第三方组织信息列表
     * 
     * @param k3Organization 存储第三方组织信息
     * @return 存储第三方组织信息
     */
    @Override
    public List<K3Organization> selectK3OrganizationList(K3Organization k3Organization)
    {
        return k3OrganizationMapper.selectK3OrganizationList(k3Organization);
    }

    /**
     * 新增存储第三方组织信息
     * 
     * @param k3Organization 存储第三方组织信息
     * @return 结果
     */
    @Override
    public int insertK3Organization(K3Organization k3Organization)
    {
        k3Organization.setCreateTime(DateUtils.getNowDate());
        return k3OrganizationMapper.insertK3Organization(k3Organization);
    }

    /**
     * 修改存储第三方组织信息
     * 
     * @param k3Organization 存储第三方组织信息
     * @return 结果
     */
    @Override
    public int updateK3Organization(K3Organization k3Organization)
    {
        k3Organization.setUpdateTime(DateUtils.getNowDate());
        return k3OrganizationMapper.updateK3Organization(k3Organization);
    }

    /**
     * 批量删除存储第三方组织信息
     * 
     * @param ids 需要删除的存储第三方组织信息主键
     * @return 结果
     */
    @Override
    public int deleteK3OrganizationByIds(Long[] ids)
    {
        return k3OrganizationMapper.deleteK3OrganizationByIds(ids);
    }

    /**
     * 删除存储第三方组织信息信息
     * 
     * @param id 存储第三方组织信息主键
     * @return 结果
     */
    @Override
    public int deleteK3OrganizationById(Long id)
    {
        return k3OrganizationMapper.deleteK3OrganizationById(id);
    }

    /**
     * 全部删除存储第三方组织信息
     *
     * @return 结果
     */
    @Override
    public int deleteK3OrganizationAll() {
        return k3OrganizationMapper.deleteK3OrganizationAll();
    }

    /**
     * 查询存储第三方组织信息
     *
     * @param forgid 存储第三方组织信息组织内码
     * @return 存储第三方组织信息
     */
    @Override
    public K3Organization selectK3OrganizationByForgid(Long forgid) {
        return k3OrganizationMapper.selectK3OrganizationByForgid(forgid);
    }

    /**
     * 查询所有第三方组织信息-下拉列表
     *
     * @return
     */
    @Override
    public List<K3Organization> selectK3OrganizationAll() {
        return k3OrganizationMapper.selectK3OrganizationAll();
    }

}
