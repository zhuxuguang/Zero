package com.zero.system.k3cloud.k3Material.mapper;

import java.util.List;

import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;

/**
 * 第三方简单生产领料单Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-04-03
 */
public interface K3SpPickmtrlMapper 
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
     * 删除第三方简单生产领料单
     * 
     * @param id 第三方简单生产领料单主键
     * @return 结果
     */
    public int deleteK3SpPickmtrlById(Long id);

    /**
     * 批量删除第三方简单生产领料单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteK3SpPickmtrlByIds(Long[] ids);

    /**
     * 全部删除第三方简单生产领料单信息
     *
     * @param
     * @return 结果
     */
    public int deleteK3SpPickmtrlAll();

    /**
     * 新增存储物料信息
     *
     * @param k3SpPickmtrl 存储物料信息
     * @return 结果
     */
    int saveInfo(K3SpPickmtrl k3SpPickmtrl);


    /**
     * 查询第三方简单生产领料单列表
     *
     * @param fstockorgIds 第三方简单生产领料单
     * @return 第三方简单生产领料单集合
     */
    public List<K3SpPickmtrl> selectKmK3SPList(List<String> fstockorgIds);
}
