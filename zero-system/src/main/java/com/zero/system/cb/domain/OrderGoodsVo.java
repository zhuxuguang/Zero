package com.zero.system.cb.domain;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author: ZhuXuGuang
 * @Description: 商品实体类
 * @Date: create in 2023/3/24 9:54
 */
public class OrderGoodsVo {

    private Integer id;

    private String goodsName;

    private String goodsSn;

    private String picUrl;

    private Integer goodsId;

    private Integer productId;

    private String[] specifications;

    private Integer number;

    private BigDecimal price;

    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String[] specifications) {
        this.specifications = specifications;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "OrderGoodsVo{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSn='" + goodsSn + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", goodsId=" + goodsId +
                ", productId=" + productId +
                ", specifications=" + Arrays.toString(specifications) +
                ", number=" + number +
                ", price=" + price +
                ", location='" + location + '\'' +
                '}';
    }
}
