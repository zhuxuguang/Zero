package com.zero.system.k3cloud.k3Organization.service;

import java.util.List;
import com.zero.system.k3cloud.k3Organization.domain.K3Organization;

/**
 * 存储第三方组织信息Service接口
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
public interface IK3OrganizationService 
{
    /**
     * 查询存储第三方组织信息
     * 
     * @param id 存储第三方组织信息主键
     * @return 存储第三方组织信息
     */
    public K3Organization selectK3OrganizationById(Long id);

    /**
     * 查询存储第三方组织信息列表
     * 
     * @param k3Organization 存储第三方组织信息
     * @return 存储第三方组织信息集合
     */
    public List<K3Organization> selectK3OrganizationList(K3Organization k3Organization);

    /**
     * 新增存储第三方组织信息
     * 
     * @param k3Organization 存储第三方组织信息
     * @return 结果
     */
    public int insertK3Organization(K3Organization k3Organization);

    /**
     * 修改存储第三方组织信息
     * 
     * @param k3Organization 存储第三方组织信息
     * @return 结果
     */
    public int updateK3Organization(K3Organization k3Organization);

    /**
     * 批量删除存储第三方组织信息
     * 
     * @param ids 需要删除的存储第三方组织信息主键集合
     * @return 结果
     */
    public int deleteK3OrganizationByIds(Long[] ids);

    /**
     * 删除存储第三方组织信息信息
     * 
     * @param id 存储第三方组织信息主键
     * @return 结果
     */
    public int deleteK3OrganizationById(Long id);

    /**
     * 全部删除存储第三方组织信息
     *
     * @param
     * @return 结果
     */
    public int deleteK3OrganizationAll();


    /**
     * 查询存储第三方组织信息
     *
     * @param forgid 存储第三方组织信息组织内码
     * @return 存储第三方组织信息
     */
    public K3Organization selectK3OrganizationByForgid(Long forgid);

    /**
     * 查询所有第三方组织信息-下拉列表
     * @return
     */
    public List<K3Organization> selectK3OrganizationAll();

}
