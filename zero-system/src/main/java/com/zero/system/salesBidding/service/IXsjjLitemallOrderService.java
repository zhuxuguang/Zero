package com.zero.system.salesBidding.service;

import java.util.List;
import com.zero.system.salesBidding.domain.XsjjLitemallOrder;
import com.zero.system.salesBidding.domain.XsjjOrder;

/**
 * 销售竞价第三方订单Service接口
 * 
 * @author ruoyi
 * @date 2023-03-24
 */
public interface IXsjjLitemallOrderService 
{
    /**
     * 查询销售竞价第三方订单
     * 
     * @param id 销售竞价第三方订单主键
     * @return 销售竞价第三方订单
     */
    public XsjjLitemallOrder selectXsjjLitemallOrderById(Long id);

    /**
     * 查询销售竞价第三方订单列表
     * 
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 销售竞价第三方订单集合
     */
    public List<XsjjLitemallOrder> selectXsjjLitemallOrderList(XsjjLitemallOrder xsjjLitemallOrder);

    /**
     * 新增销售竞价第三方订单
     * 
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 结果
     */
    public int insertXsjjLitemallOrder(XsjjLitemallOrder xsjjLitemallOrder);

    /**
     * 修改销售竞价第三方订单
     * 
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 结果
     */
    public int updateXsjjLitemallOrder(XsjjLitemallOrder xsjjLitemallOrder);

    /**
     * 批量删除销售竞价第三方订单
     * 
     * @param ids 需要删除的销售竞价第三方订单主键集合
     * @return 结果
     */
    public int deleteXsjjLitemallOrderByIds(Long[] ids);

    /**
     * 删除销售竞价第三方订单信息
     * 
     * @param id 销售竞价第三方订单主键
     * @return 结果
     */
    public int deleteXsjjLitemallOrderById(Long id);


    /**
     * 查询有效销售竞价第三方订单列表
     *
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 有效销售竞价第三方订单集合
     */
    public List<XsjjLitemallOrder> selectVaildXsjjLitemallOrderList(XsjjLitemallOrder xsjjLitemallOrder);


    /**
     * 执行全部删除
     */
    void deleteAllXsjjLitemallOrder();

    /**
     * 查询最大订单添加时间
     * @param xsjjLitemallOrder
     * @return
     */
    public List<XsjjLitemallOrder> queryMaxAddTime(XsjjLitemallOrder xsjjLitemallOrder);
}
