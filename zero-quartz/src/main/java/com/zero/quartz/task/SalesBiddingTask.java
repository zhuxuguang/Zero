package com.zero.quartz.task;

import com.zero.common.utils.DateUtils;
import com.zero.system.cb.domain.SalesBidding;
import com.zero.system.salesBidding.domain.XsjjLitemallOrder;
import com.zero.system.salesBidding.domain.XsjjOrder;
import com.zero.system.salesBidding.service.IXsjjLitemallOrderService;
import com.zero.system.salesBidding.service.IXsjjOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZhuXuGuang
 * @Description: 第三方数据抓取，有效订单获取
 * @Date: create in 2023/3/27 10:01
 */
@Component("salesBiddingTask")
@Slf4j
public class SalesBiddingTask {

    //销售竞价第三方订单
    @Autowired
    private IXsjjLitemallOrderService xsjjLitemallOrderService;


    //有效订单列表
    @Autowired
    private IXsjjOrderService xsjjOrderService;

    /**
     * 定时抓取销售竞价第三方订单
     * 10分钟一次
     */
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public void insertXsjjLitemallOrderTask(){
        log.info("@@开始自动抓取销售竞价第三方订单.....");
        //第三方实体类
        XsjjLitemallOrder xsjjLitemallOrder = new XsjjLitemallOrder();
        try{
            //获取接口数据
            URL url = new URL("http://fyy.chinafymy.com:8083/admin/order/listVo");
            //根据url对象来生成一个打开连接http请求
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;

            while(null != (line = br.readLine())){
                //清理历史数据
                //xsjjLitemallOrderService.deleteAllXsjjLitemallOrder();

                // 解析为JSONObject
                JSONObject obj = JSONObject.parseObject(line);
                JSONObject d_ = obj.getJSONObject("data");
//                System.out.println(String.valueOf(d_));
                JSONArray dd_ = d_.getJSONArray("list");
                String jsonStr = JSONObject.toJSONString(dd_);
                //json转换list实体类中
                List<SalesBidding> biddings = JSONObject.parseArray(jsonStr, SalesBidding.class);

                //查询最大有效订单时间
                List<XsjjLitemallOrder> listXlo = xsjjLitemallOrderService.queryMaxAddTime(xsjjLitemallOrder);
                Date Max_AddTime = DateUtils.parseDate("2020-01-01 00:00:00");
                for (int i = 0; i < biddings.size(); i++){
                    SalesBidding sb = biddings.get(i);
                    if (listXlo.size() > 0){
                        Max_AddTime = listXlo.get(0).getAddTime();
                    }
                    //时间对比，只有当第三方订单集合中的订单时间大于历史最大订单时间，数据才会进行更新
                    if (sb.getAddTime().getTime() > Max_AddTime.getTime()){
                        //传参存储
                        xsjjLitemallOrder.setOrderSn(sb.getOrderSn());
                        xsjjLitemallOrder.setOrderStatus(sb.getOrderStatus().longValue());
                        xsjjLitemallOrder.setActualPrice(sb.getActualPrice());
                        xsjjLitemallOrder.setVehicleNumber(sb.getVehicleNumber());
                        xsjjLitemallOrder.setHeadNumber(sb.getHeadNumber());
                        xsjjLitemallOrder.setIntegralprice(sb.getIntegralPrice());
                        xsjjLitemallOrder.setFreightprice(sb.getFreightPrice());
                        xsjjLitemallOrder.setOrderPrice(sb.getOrderPrice());
                        xsjjLitemallOrder.setAddTime(sb.getAddTime());
                        xsjjLitemallOrder.setUserId(sb.getUserId().longValue());
                        xsjjLitemallOrder.setUserName(sb.getUserName());
                        xsjjLitemallOrder.setUserAvatar(sb.getUserAvatar());
                        xsjjLitemallOrder.setConsignee(sb.getConsignee());
                        xsjjLitemallOrder.setAddress(sb.getAddress());
                        xsjjLitemallOrder.setMobile(sb.getMobile());
                        xsjjLitemallOrder.setGoodsNamev(sb.getGoodsNamev());
                        xsjjLitemallOrder.setGoodsSnv(sb.getGoodsSnv());
                        xsjjLitemallOrderService.insertXsjjLitemallOrder(xsjjLitemallOrder);
                    }
                }
            }
            //关闭接口
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }


    /**
     * 定时存储有效订单信息
     * 5分钟一次
     */
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public void insertXsjjOrderTask(){

        log.info("@@开始自动存储有效订单信息.....");

        XsjjOrder xsjjOrder = new XsjjOrder();
        //第三方实体类
        XsjjLitemallOrder xsjjLitemallOrder = new XsjjLitemallOrder();
        try {
            //清除历史数据 暂时没更好办法
            xsjjOrderService.deleteAllXsjjOrder();
            //查询有效订单集合
            List<XsjjLitemallOrder> listXlo = xsjjLitemallOrderService.selectVaildXsjjLitemallOrderList(xsjjLitemallOrder);
//            //查询最大有效订单时间
//            List<XsjjOrder> listXo = xsjjOrderService.queryMaxAddTime(xsjjOrder);
//            Date Max_AddTime = DateUtils.parseDate("2020-01-01 00:00:00");
            for (int i = 0; i < listXlo.size(); i++){
                XsjjLitemallOrder xlo = listXlo.get(i);
//                if (listXo.size() > 0){
//                    Max_AddTime = listXo.get(0).getAddTime();
//                }
//                //时间对比，只有当有效订单集合中的订单时间大于最大有效订单时间，数据才会进行更新
//                if (xlo.getAddTime().getTime() > Max_AddTime.getTime()){
//
//                }
                xsjjOrder.setOrderSn(xlo.getOrderSn());
                xsjjOrder.setOrderStatus(xlo.getOrderStatus());
                xsjjOrder.setActualPrice(xlo.getActualPrice());
                xsjjOrder.setVehicleNumber(xlo.getVehicleNumber());
                xsjjOrder.setHeadNumber(xlo.getHeadNumber());
                xsjjOrder.setIntegralprice(xlo.getIntegralprice());
                xsjjOrder.setFreightprice(xlo.getFreightprice());
                xsjjOrder.setOrderPrice(xlo.getOrderPrice());
                xsjjOrder.setAddTime(xlo.getAddTime());
                xsjjOrder.setUserId(xlo.getUserId());
                xsjjOrder.setUserName(xlo.getUserName());
                xsjjOrder.setUserAvatar(xlo.getUserAvatar());
                xsjjOrder.setConsignee(xlo.getConsignee());
                xsjjOrder.setAddress(xlo.getAddress());
                xsjjOrder.setMobile(xlo.getMobile());
                xsjjOrder.setGoodsNamev(xlo.getGoodsNamev());
                xsjjOrder.setGoodsSnv(xlo.getGoodsSnv());
                xsjjOrderService.insertXsjjOrder(xsjjOrder);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
