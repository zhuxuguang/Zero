package com.zero.system.k3cloud.k3Material.service;

import java.util.List;

import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialbase;
import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;

/**
 * 第三方简单生产领料单Service接口
 * 
 * @author zhuxuguang
 * @date 2023-04-03
 */
public interface IK3SpPickmtrlService 
{
    /**
     * 查询第三方简单生产领料单
     * 
     * @param id 第三方简单生产领料单主键
     * @return 第三方简单生产领料单
     */
    public K3SpPickmtrl selectK3SpPickmtrlById(Long id);

    /**
     * 查询第三方简单生产领料单列表
     * 
     * @param k3SpPickmtrl 第三方简单生产领料单
     * @return 第三方简单生产领料单集合
     */
    public List<K3SpPickmtrl> selectK3SpPickmtrlList(K3SpPickmtrl k3SpPickmtrl);

    /**
     * 新增第三方简单生产领料单
     * 
     * @param k3SpPickmtrl 第三方简单生产领料单
     * @return 结果
     */
    public int insertK3SpPickmtrl(K3SpPickmtrl k3SpPickmtrl);

    /**
     * 修改第三方简单生产领料单
     * 
     * @param k3SpPickmtrl 第三方简单生产领料单
     * @return 结果
     */
    public int updateK3SpPickmtrl(K3SpPickmtrl k3SpPickmtrl);

    /**
     * 批量删除第三方简单生产领料单
     * 
     * @param ids 需要删除的第三方简单生产领料单主键集合
     * @return 结果
     */
    public int deleteK3SpPickmtrlByIds(Long[] ids);

    /**
     * 删除第三方简单生产领料单信息
     * 
     * @param id 第三方简单生产领料单主键
     * @return 结果
     */
    public int deleteK3SpPickmtrlById(Long id);

    /**
     * 全部删除第三方简单生产领料单信息
     *
     * @param
     * @return 结果
     */
    public int deleteK3SpPickmtrlAll();

    /**
     * 使用sqlSessionFactory实现批量插入
     * @param list
     */
    void saveBeach(List<K3SpPickmtrl> list);

    /**
     * 查询第三方简单生产领料单列表-只查询处在映射关系下的的单据
     * @param
     * @return
     */
    public List<K3SpPickmtrl> selectKmK3SPList();
}
