package com.zero.system.salesBidding.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.salesBidding.mapper.XsjjOrderMapper;
import com.zero.system.salesBidding.domain.XsjjOrder;
import com.zero.system.salesBidding.service.IXsjjOrderService;

/**
 * 有效订单Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-03-25
 */
@Service
public class XsjjOrderServiceImpl implements IXsjjOrderService 
{
    @Autowired
    private XsjjOrderMapper xsjjOrderMapper;

    /**
     * 查询有效订单
     * 
     * @param id 有效订单主键
     * @return 有效订单
     */
    @Override
    public XsjjOrder selectXsjjOrderById(Long id)
    {
        return xsjjOrderMapper.selectXsjjOrderById(id);
    }

    /**
     * 查询有效订单列表
     * 
     * @param xsjjOrder 有效订单
     * @return 有效订单
     */
    @Override
    public List<XsjjOrder> selectXsjjOrderList(XsjjOrder xsjjOrder)
    {
        return xsjjOrderMapper.selectXsjjOrderList(xsjjOrder);
    }

    /**
     * 新增有效订单
     * 
     * @param xsjjOrder 有效订单
     * @return 结果
     */
    @Override
    public int insertXsjjOrder(XsjjOrder xsjjOrder)
    {
        xsjjOrder.setCreateTime(DateUtils.getNowDate());
        return xsjjOrderMapper.insertXsjjOrder(xsjjOrder);
    }

    /**
     * 修改有效订单
     * 
     * @param xsjjOrder 有效订单
     * @return 结果
     */
    @Override
    public int updateXsjjOrder(XsjjOrder xsjjOrder)
    {
        xsjjOrder.setUpdateTime(DateUtils.getNowDate());
        return xsjjOrderMapper.updateXsjjOrder(xsjjOrder);
    }

    /**
     * 批量删除有效订单
     * 
     * @param ids 需要删除的有效订单主键
     * @return 结果
     */
    @Override
    public int deleteXsjjOrderByIds(Long[] ids)
    {
        return xsjjOrderMapper.deleteXsjjOrderByIds(ids);
    }

    /**
     * 删除有效订单信息
     * 
     * @param id 有效订单主键
     * @return 结果
     */
    @Override
    public int deleteXsjjOrderById(Long id)
    {
        return xsjjOrderMapper.deleteXsjjOrderById(id);
    }

    /**
     * 查询最大订单添加时间
     *
     * @param xsjjOrder
     * @return
     */
    @Override
    public List<XsjjOrder> queryMaxAddTime(XsjjOrder xsjjOrder) {
        return xsjjOrderMapper.queryMaxAddTime(xsjjOrder);
    }

    /**
     * 执行全部删除
     */
    @Override
    public void deleteAllXsjjOrder() {
        xsjjOrderMapper.deleteAllXsjjOrder();
    }
}
