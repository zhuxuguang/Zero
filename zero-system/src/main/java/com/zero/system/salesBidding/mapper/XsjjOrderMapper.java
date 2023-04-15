package com.zero.system.salesBidding.mapper;

import java.util.List;
import com.zero.system.salesBidding.domain.XsjjOrder;

/**
 * 有效订单Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-03-25
 */
public interface XsjjOrderMapper 
{
    /**
     * 查询有效订单
     * 
     * @param id 有效订单主键
     * @return 有效订单
     */
    public XsjjOrder selectXsjjOrderById(Long id);

    /**
     * 查询有效订单列表
     * 
     * @param xsjjOrder 有效订单
     * @return 有效订单集合
     */
    public List<XsjjOrder> selectXsjjOrderList(XsjjOrder xsjjOrder);

    /**
     * 新增有效订单
     * 
     * @param xsjjOrder 有效订单
     * @return 结果
     */
    public int insertXsjjOrder(XsjjOrder xsjjOrder);

    /**
     * 修改有效订单
     * 
     * @param xsjjOrder 有效订单
     * @return 结果
     */
    public int updateXsjjOrder(XsjjOrder xsjjOrder);

    /**
     * 删除有效订单
     * 
     * @param id 有效订单主键
     * @return 结果
     */
    public int deleteXsjjOrderById(Long id);

    /**
     * 批量删除有效订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXsjjOrderByIds(Long[] ids);

    /**
     * 查询最大订单添加时间
     * @param xsjjOrder
     * @return
     */
    public List<XsjjOrder> queryMaxAddTime(XsjjOrder xsjjOrder);

    /**
     * 执行全部删除
     */
    void deleteAllXsjjOrder();
}
