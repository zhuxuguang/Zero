package com.zero.system.k3cloud.k3Organization.mapper;

import java.util.List;
import com.zero.system.k3cloud.k3Organization.domain.K3OrganizationMap;

/**
 * 组织间映射Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-04-05
 */
public interface K3OrganizationMapMapper 
{
    /**
     * 查询组织间映射
     * 
     * @param id 组织间映射主键
     * @return 组织间映射
     */
    public K3OrganizationMap selectK3OrganizationMapById(Long id);

    /**
     * 查询组织间映射列表
     * 
     * @param k3OrganizationMap 组织间映射
     * @return 组织间映射集合
     */
    public List<K3OrganizationMap> selectK3OrganizationMapList(K3OrganizationMap k3OrganizationMap);

    /**
     * 新增组织间映射
     * 
     * @param k3OrganizationMap 组织间映射
     * @return 结果
     */
    public int insertK3OrganizationMap(K3OrganizationMap k3OrganizationMap);

    /**
     * 修改组织间映射
     * 
     * @param k3OrganizationMap 组织间映射
     * @return 结果
     */
    public int updateK3OrganizationMap(K3OrganizationMap k3OrganizationMap);

    /**
     * 删除组织间映射
     * 
     * @param id 组织间映射主键
     * @return 结果
     */
    public int deleteK3OrganizationMapById(Long id);

    /**
     * 批量删除组织间映射
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteK3OrganizationMapByIds(Long[] ids);


    /**
     * 查询所以映射组织信息
     * @return
     */
    public List<K3OrganizationMap> selectK3OrganizationMapAll();

    /**
     * 查询组织间映射
     *
     * @param k3Forgid 组织间映射主键 - 第三方组织内码
     * @return 组织间映射
     */
    public K3OrganizationMap selectK3OMByk3Forgid(String k3Forgid);
}
