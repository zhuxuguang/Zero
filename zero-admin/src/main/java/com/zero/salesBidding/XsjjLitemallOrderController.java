package com.zero.salesBidding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zero.common.utils.DateUtils;
import com.zero.system.cb.domain.SalesBidding;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zero.common.annotation.Log;
import com.zero.common.core.controller.BaseController;
import com.zero.common.core.domain.AjaxResult;
import com.zero.common.enums.BusinessType;
import com.zero.system.salesBidding.domain.XsjjLitemallOrder;
import com.zero.system.salesBidding.service.IXsjjLitemallOrderService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 销售竞价第三方订单Controller
 * 
 * @author ruoyi
 * @date 2023-03-24
 */
@RestController
@RequestMapping("/system/salesBidding/xsjjLitemallOrder")
public class XsjjLitemallOrderController extends BaseController
{
    @Autowired
    private IXsjjLitemallOrderService xsjjLitemallOrderService;

    /**
     * 查询销售竞价第三方订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(XsjjLitemallOrder xsjjLitemallOrder)
    {
        startPage();
        List<XsjjLitemallOrder> list = xsjjLitemallOrderService.selectXsjjLitemallOrderList(xsjjLitemallOrder);
        return getDataTable(list);
    }

    /**
     * 导出销售竞价第三方订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:export')")
    @Log(title = "销售竞价第三方订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XsjjLitemallOrder xsjjLitemallOrder)
    {
        List<XsjjLitemallOrder> list = xsjjLitemallOrderService.selectXsjjLitemallOrderList(xsjjLitemallOrder);
        ExcelUtil<XsjjLitemallOrder> util = new ExcelUtil<XsjjLitemallOrder>(XsjjLitemallOrder.class);
        util.exportExcel(response, list, "销售竞价第三方订单数据");
    }

    /**
     * 获取销售竞价第三方订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xsjjLitemallOrderService.selectXsjjLitemallOrderById(id));
    }

    /**
     * 新增销售竞价第三方订单
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:add')")
    @Log(title = "销售竞价第三方订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XsjjLitemallOrder xsjjLitemallOrder)
    {
        return toAjax(xsjjLitemallOrderService.insertXsjjLitemallOrder(xsjjLitemallOrder));
    }

    /**
     * 修改销售竞价第三方订单
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:edit')")
    @Log(title = "销售竞价第三方订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XsjjLitemallOrder xsjjLitemallOrder)
    {
        return toAjax(xsjjLitemallOrderService.updateXsjjLitemallOrder(xsjjLitemallOrder));
    }

    /**
     * 删除销售竞价第三方订单
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:remove')")
    @Log(title = "销售竞价第三方订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xsjjLitemallOrderService.deleteXsjjLitemallOrderByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('system:xsjjLitemallOrder:acquire')")
    @Log(title = "销售竞价第三方订单", businessType = BusinessType.EXPORT)
    @PostMapping("/acquire")
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult acquire(){

        //第三方实体类
        XsjjLitemallOrder xsjjLitemallOrder = new XsjjLitemallOrder();

        try{
            //获取接口数据
            URL url = new URL("URL地址");
            //根据url对象来生成一个打开连接http请求
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;

            while(null != (line = br.readLine())){
                //清理历史数据
                //xsjjLitemallOrderService.deleteAllXsjjLitemallOrder();

                // 解析为JSONObject
                JSONObject obj = JSONObject.parseObject(line);
                JSONObject d_ = obj.getJSONObject("data");
                System.out.println(String.valueOf(d_));
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
            return error("数据获取失败，错误如下：" + e.getMessage());
        }
        return success("数据执行成功");

    }
}
