package com.zero.system.cb.domain;

import com.zero.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZhuXuGuang
 * @Description: 销售竞价 实体类
 *          "id": 234,
 * 			"orderSn": "20220826229965",
 * 			"orderStatus": 201,
 * 			"actualPrice": 22.10,
 * 			"vehicleNumber": 2,
 * 			"headNumber": 260,
 * 			"integralPrice": 0.00,
 * 			"freightPrice": 0.00,
 * 			"orderPrice": 22.10,
 * 			"addTime": "2022-08-26 10:28:11",
 * 			"userId": 69,
 * 			"userName": "聂广训13603423418",
 * 			"userAvatar": "https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL1BZ9fffVx3YbceD52vMHUhgmTodric7ObE7U6WDwSX0Fk2P3jzGe9ias9nDmMx5WTk9FyYGJHzseA/132",
 * 			"consignee": "聂广训",
 * 			"address": "河南省驻马店市遂平县 肉蛋禽",
 * 			"mobile": "13603423418",
 * 			"message": "",
 * 			"goodsVoList": [{
 * 				"id": 234,
 * 				"goodsName": "西平中转站销售育肥猪260余头",
 * 				"goodsSn": "FYHP20220823001",
 * 				"picUrl": "https://fyy.chinafymy.com/storage/tov366wxpels5dxl9nrr.png",
 * 				"goodsId": 1181045,
 * 				"productId": 292,
 * 				"specifications": ["标准"],
 * 				"number": 1,
 * 				"price": 1.00
 *                        }],
 * 			"goodsNamev": "西平中转站销售育肥猪260余头",
 * 			"goodsSnv": "FYHP20220823001"
 * @Date: create in 2023/3/23 13:24
 */
public class SalesBidding extends BaseEntity {

    /** ID */
    private Integer id;

    /** 订单编号 */
    private String orderSn;

    /** 订单状态 */
    private Integer orderStatus;

    /** 实付费用 */
    private BigDecimal actualPrice;

    /** 车辆数 */
    private BigDecimal vehicleNumber;

    /** 头数 */
    private BigDecimal headNumber;

    /** 原值1 */
    private BigDecimal integralPrice;

    /** 原值2 */
    private BigDecimal freightPrice;

    /** 实报金额 */
    private BigDecimal orderPrice;

    /** 下单时间 */
    private Date addTime;

    /** 下单用户ID */
    private Integer userId;

    /** 下单用户名称 */
    private String userName;

    /** 用户头像 */
    private String userAvatar;


    /** 联系人 */
    private String consignee;

    /** 联系地址 */
    private String address;

    /** 联系电话 */
    private String mobile;

    /** 用户订单留言 */
    private String message;

    /** 物料详情 */
    private List<OrderGoodsVo> goodsVoList;

    /** 商品名称 */
    private String goodsNamev;

    /** 商品编号 */
    private String goodsSnv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(BigDecimal vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public BigDecimal getHeadNumber() {
        return headNumber;
    }

    public void setHeadNumber(BigDecimal headNumber) {
        this.headNumber = headNumber;
    }

    public BigDecimal getIntegralPrice() {
        return integralPrice;
    }

    public void setIntegralPrice(BigDecimal integralPrice) {
        this.integralPrice = integralPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OrderGoodsVo> getGoodsVoList() {
        return goodsVoList;
    }

    public void setGoodsVoList(List<OrderGoodsVo> goodsVoList) {
        this.goodsVoList = goodsVoList;
    }

    public String getGoodsNamev() {
        return goodsNamev;
    }

    public void setGoodsNamev(String goodsNamev) {
        this.goodsNamev = goodsNamev;
    }

    public String getGoodsSnv() {
        return goodsSnv;
    }

    public void setGoodsSnv(String goodsSnv) {
        this.goodsSnv = goodsSnv;
    }

    @Override
    public String toString() {
        return "SalesBidding{" +
                "id=" + id +
                ", orderSn='" + orderSn + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", actualPrice=" + actualPrice +
                ", vehicleNumber=" + vehicleNumber +
                ", headNumber=" + headNumber +
                ", integralPrice=" + integralPrice +
                ", freightPrice=" + freightPrice +
                ", orderPrice=" + orderPrice +
                ", addTime='" + addTime + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", consignee='" + consignee + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", message='" + message + '\'' +
                ", goodsVoList=" + goodsVoList +
                ", goodsNamev='" + goodsNamev + '\'' +
                ", goodsSnv='" + goodsSnv + '\'' +
                '}';
    }
}
