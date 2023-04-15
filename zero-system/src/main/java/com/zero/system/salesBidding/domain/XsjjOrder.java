package com.zero.system.salesBidding.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 有效订单对象 xsjj_order
 *
 * @author zhuxuguang
 * @date 2023-03-25
 */
public class XsjjOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderSn;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long orderStatus;

    /** 实付费用 */
    @Excel(name = "实付费用")
    private BigDecimal actualPrice;

    /** 车辆数 */
    @Excel(name = "车辆数")
    private BigDecimal vehicleNumber;

    /** 头数 */
    @Excel(name = "头数")
    private BigDecimal headNumber;

    /** 原值1 */
    @Excel(name = "原值1")
    private BigDecimal integralprice;

    /** 原值2 */
    @Excel(name = "原值2")
    private BigDecimal freightprice;

    /** 订单费用 */
    @Excel(name = "订单费用")
    private BigDecimal orderPrice;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 下单用户ID */
    @Excel(name = "下单用户ID")
    private Long userId;

    /** 下单用户名称 */
    @Excel(name = "下单用户名称")
    private String userName;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String userAvatar;

    /** 联系人 */
    @Excel(name = "联系人")
    private String consignee;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String address;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String mobile;

    /** 用户订单留言 */
    @Excel(name = "用户订单留言")
    private String message;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsNamev;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private String goodsSnv;

    /** 计算状态 */
    @Excel(name = "计算状态")
    private String countStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderSn(String orderSn)
    {
        this.orderSn = orderSn;
    }

    public String getOrderSn()
    {
        return orderSn;
    }
    public void setOrderStatus(Long orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Long getOrderStatus()
    {
        return orderStatus;
    }
    public void setActualPrice(BigDecimal actualPrice)
    {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getActualPrice()
    {
        return actualPrice;
    }
    public void setVehicleNumber(BigDecimal vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;
    }

    public BigDecimal getVehicleNumber()
    {
        return vehicleNumber;
    }
    public void setHeadNumber(BigDecimal headNumber)
    {
        this.headNumber = headNumber;
    }

    public BigDecimal getHeadNumber()
    {
        return headNumber;
    }
    public void setIntegralprice(BigDecimal integralprice)
    {
        this.integralprice = integralprice;
    }

    public BigDecimal getIntegralprice()
    {
        return integralprice;
    }
    public void setFreightprice(BigDecimal freightprice)
    {
        this.freightprice = freightprice;
    }

    public BigDecimal getFreightprice()
    {
        return freightprice;
    }
    public void setOrderPrice(BigDecimal orderPrice)
    {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderPrice()
    {
        return orderPrice;
    }
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }

    public Date getAddTime()
    {
        return addTime;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setUserAvatar(String userAvatar)
    {
        this.userAvatar = userAvatar;
    }

    public String getUserAvatar()
    {
        return userAvatar;
    }
    public void setConsignee(String consignee)
    {
        this.consignee = consignee;
    }

    public String getConsignee()
    {
        return consignee;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
    public void setGoodsNamev(String goodsNamev)
    {
        this.goodsNamev = goodsNamev;
    }

    public String getGoodsNamev()
    {
        return goodsNamev;
    }
    public void setGoodsSnv(String goodsSnv)
    {
        this.goodsSnv = goodsSnv;
    }

    public String getGoodsSnv()
    {
        return goodsSnv;
    }
    public void setCountStatus(String countStatus)
    {
        this.countStatus = countStatus;
    }

    public String getCountStatus()
    {
        return countStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderSn", getOrderSn())
                .append("orderStatus", getOrderStatus())
                .append("actualPrice", getActualPrice())
                .append("vehicleNumber", getVehicleNumber())
                .append("headNumber", getHeadNumber())
                .append("integralprice", getIntegralprice())
                .append("freightprice", getFreightprice())
                .append("orderPrice", getOrderPrice())
                .append("addTime", getAddTime())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("userAvatar", getUserAvatar())
                .append("consignee", getConsignee())
                .append("address", getAddress())
                .append("mobile", getMobile())
                .append("message", getMessage())
                .append("goodsNamev", getGoodsNamev())
                .append("goodsSnv", getGoodsSnv())
                .append("countStatus", getCountStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
