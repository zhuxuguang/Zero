package com.zero.cb;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import com.zero.system.cb.domain.SalesBidding;
import com.zero.system.salesBidding.domain.XsjjLitemallOrder;
import com.zero.system.salesBidding.service.IXsjjLitemallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @Author: ZhuXuGuang
 * @Description: 销售竞价接口抓取数据
 * @Date: create in 2023/3/23 12:19
 */
@Component //将工具类声明为spring组件，这个必须不能忘
public class SalesBiddingController {

    @Autowired
    private IXsjjLitemallOrderService xsjjLitemallOrderService;

    // 静态初使化当前类
    private static SalesBiddingController salesBiddingController;

    @PostConstruct//在方法上加上注解@PostConstruct，这样方法就会在Bean初始化之后被Spring容器执行（注：Bean初始化包括，实例化Bean，并装配Bean的属性（依赖注入））。
    public void init() {
        salesBiddingController = this;
    }

    public static void main(String[] args) throws IOException {

        //get请求获取数据接口
        try {
            //获取接口数据
            URL url = new URL("http://fyy.chinafymy.com:8083/admin/order/listVo");
            //根据url对象来生成一个打开连接http请求
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while (null != (line = br.readLine())) {
                System.out.println(line);
                // 解析为JSONObject
                JSONObject obj = JSONObject.parseObject(line);
                JSONObject d_ = obj.getJSONObject("data");

                System.out.println(String.valueOf(d_));
                JSONArray dd_ = d_.getJSONArray("list");

                String jsonStr = JSONObject.toJSONString(dd_);
                //json转换list实体类中
                List<SalesBidding> biddings = JSONObject.parseArray(jsonStr, SalesBidding.class);

                XsjjLitemallOrder xsjjLitemallOrder = new XsjjLitemallOrder();
                for (int i = 0; i < biddings.size(); i++) {
                    SalesBidding sb = biddings.get(i);
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

                    salesBiddingController.xsjjLitemallOrderService.insertXsjjLitemallOrder(xsjjLitemallOrder);


                }

                biddings.forEach(b -> {

                    System.out.println(b);
                });
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//
//        //post请求获取数据接口
//        try {
//            //获取接口数据http://localhost:8083/admin/order/list?username=admin123&password=fyjt1688
//            URL url = new URL("http://localhost:8083/admin/order/listPostVo");
//            //根据url对象来生成一个打开连接http请求
//            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//            //设置请求方式
//            connection.setRequestMethod("POST");
//            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line = null;
//            while(null != (line = br.readLine())){
//                System.out.println(line);
//                // 解析为JSONObject
//                JSONObject obj = JSONObject.parseObject(line);
//                JSONObject d_ = obj.getJSONObject("data");
//
//                System.out.println(String.valueOf(d_));
//                JSONArray dd_ = d_.getJSONArray("list");
//
//                String jsonStr = JSONObject.toJSONString(dd_);
//                //json转换list实体类中
//                List<SalesBidding> biddings = JSONObject.parseArray(jsonStr, SalesBidding.class);
//
//                XsjjLitemallOrder xsjjLitemallOrder = new XsjjLitemallOrder();
//                for (int i = 0; i < biddings.size(); i++){
//                    SalesBidding sb = biddings.get(i);
//                    //传参存储
//                    xsjjLitemallOrder.setOrderSn(sb.getOrderSn());
//                    xsjjLitemallOrder.setOrderStatus(sb.getOrderStatus().longValue());
//                    xsjjLitemallOrder.setActualPrice(sb.getActualPrice());
//                    xsjjLitemallOrder.setVehicleNumber(sb.getVehicleNumber());
//                    xsjjLitemallOrder.setHeadNumber(sb.getHeadNumber());
//                    xsjjLitemallOrder.setIntegralprice(sb.getIntegralPrice());
//                    xsjjLitemallOrder.setFreightprice(sb.getFreightPrice());
//                    xsjjLitemallOrder.setOrderPrice(sb.getOrderPrice());
//                    xsjjLitemallOrder.setAddTime(sb.getAddTime());
//                    xsjjLitemallOrder.setUserId(sb.getUserId().longValue());
//                    xsjjLitemallOrder.setUserName(sb.getUserName());
//                    xsjjLitemallOrder.setUserAvatar(sb.getUserAvatar());
//                    xsjjLitemallOrder.setConsignee(sb.getConsignee());
//                    xsjjLitemallOrder.setAddress(sb.getAddress());
//                    xsjjLitemallOrder.setMobile(sb.getMobile());
//                    xsjjLitemallOrder.setGoodsNamev(sb.getGoodsNamev());
//                    xsjjLitemallOrder.setGoodsSnv(sb.getGoodsSnv());
//
//                    //salesBiddingController.xsjjLitemallOrderService.insertXsjjLitemallOrder(xsjjLitemallOrder);
//
//
//                }
//
//                biddings.forEach(b->{
//
//                    System.out.println(b);
//                });
//            }
//
//            br.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }


