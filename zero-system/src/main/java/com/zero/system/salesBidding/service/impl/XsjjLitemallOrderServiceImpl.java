package com.zero.system.salesBidding.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.salesBidding.mapper.XsjjLitemallOrderMapper;
import com.zero.system.salesBidding.domain.XsjjLitemallOrder;
import com.zero.system.salesBidding.service.IXsjjLitemallOrderService;

/**
 * 销售竞价第三方订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-24
 */
@Service
public class XsjjLitemallOrderServiceImpl implements IXsjjLitemallOrderService 
{
    @Autowired
    private XsjjLitemallOrderMapper xsjjLitemallOrderMapper;

    /**
     * 查询销售竞价第三方订单
     * 
     * @param id 销售竞价第三方订单主键
     * @return 销售竞价第三方订单
     */
    @Override
    public XsjjLitemallOrder selectXsjjLitemallOrderById(Long id)
    {
        return xsjjLitemallOrderMapper.selectXsjjLitemallOrderById(id);
    }

    /**
     * 查询销售竞价第三方订单列表
     * 
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 销售竞价第三方订单
     */
    @Override
    public List<XsjjLitemallOrder> selectXsjjLitemallOrderList(XsjjLitemallOrder xsjjLitemallOrder)
    {
        return xsjjLitemallOrderMapper.selectXsjjLitemallOrderList(xsjjLitemallOrder);
    }

    /**
     * 新增销售竞价第三方订单
     * 
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 结果
     */
    @Override
    public int insertXsjjLitemallOrder(XsjjLitemallOrder xsjjLitemallOrder)
    {
        xsjjLitemallOrder.setCreateTime(DateUtils.getNowDate());
        return xsjjLitemallOrderMapper.insertXsjjLitemallOrder(xsjjLitemallOrder);
    }

    /**
     * 修改销售竞价第三方订单
     * 
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 结果
     */
    @Override
    public int updateXsjjLitemallOrder(XsjjLitemallOrder xsjjLitemallOrder)
    {
        xsjjLitemallOrder.setUpdateTime(DateUtils.getNowDate());
        return xsjjLitemallOrderMapper.updateXsjjLitemallOrder(xsjjLitemallOrder);
    }

    /**
     * 批量删除销售竞价第三方订单
     * 
     * @param ids 需要删除的销售竞价第三方订单主键
     * @return 结果
     */
    @Override
    public int deleteXsjjLitemallOrderByIds(Long[] ids)
    {
        return xsjjLitemallOrderMapper.deleteXsjjLitemallOrderByIds(ids);
    }

    /**
     * 删除销售竞价第三方订单信息
     * 
     * @param id 销售竞价第三方订单主键
     * @return 结果
     */
    @Override
    public int deleteXsjjLitemallOrderById(Long id)
    {
        return xsjjLitemallOrderMapper.deleteXsjjLitemallOrderById(id);
    }

    /**
     * 查询有效销售竞价第三方订单列表
     *
     * @param xsjjLitemallOrder 销售竞价第三方订单
     * @return 有效销售竞价第三方订单集合
     */
    @Override
    public List<XsjjLitemallOrder> selectVaildXsjjLitemallOrderList(XsjjLitemallOrder xsjjLitemallOrder) {
        return xsjjLitemallOrderMapper.selectVaildXsjjLitemallOrderList(xsjjLitemallOrder);
    }

    /**
     * 执行全部删除
     */
    @Override
    public void deleteAllXsjjLitemallOrder() {
        xsjjLitemallOrderMapper.deleteAllXsjjLitemallOrder();
    }

    /**
     * 查询最大订单添加时间
     *
     * @param xsjjLitemallOrder
     * @return
     */
    @Override
    public List<XsjjLitemallOrder> queryMaxAddTime(XsjjLitemallOrder xsjjLitemallOrder) {
        return xsjjLitemallOrderMapper.queryMaxAddTime(xsjjLitemallOrder);
    }
}
