package com.zero.salesBidding;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.zero.common.utils.DateUtils;
import com.zero.system.salesBidding.domain.XsjjLitemallOrder;
import com.zero.system.salesBidding.service.IXsjjLitemallOrderService;
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
import com.zero.system.salesBidding.domain.XsjjOrder;
import com.zero.system.salesBidding.service.IXsjjOrderService;
import com.zero.common.utils.poi.ExcelUtil;
import com.zero.common.core.page.TableDataInfo;

/**
 * 有效订单Controller
 * 接受有效订单
 * @author zhuxuguang
 * @date 2023-03-25
 */
@RestController
@RequestMapping("/system/salesBidding/xsjjOrder")
public class XsjjOrderController extends BaseController
{
    @Autowired
    private IXsjjOrderService xsjjOrderService;

    //第三方销售订单接口
    @Autowired
    private IXsjjLitemallOrderService xsjjLitemallOrderService;

    /**
     * 查询有效订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(XsjjOrder xsjjOrder)
    {
        startPage();
        List<XsjjOrder> list = xsjjOrderService.selectXsjjOrderList(xsjjOrder);
        return getDataTable(list);
    }

    /**
     * 导出有效订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:export')")
    @Log(title = "有效订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XsjjOrder xsjjOrder)
    {
        List<XsjjOrder> list = xsjjOrderService.selectXsjjOrderList(xsjjOrder);
        ExcelUtil<XsjjOrder> util = new ExcelUtil<XsjjOrder>(XsjjOrder.class);
        util.exportExcel(response, list, "有效订单数据");
    }

    /**
     * 获取有效订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xsjjOrderService.selectXsjjOrderById(id));
    }

    /**
     * 新增有效订单
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:add')")
    @Log(title = "有效订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XsjjOrder xsjjOrder)
    {
        return toAjax(xsjjOrderService.insertXsjjOrder(xsjjOrder));
    }

    /**
     * 修改有效订单
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:edit')")
    @Log(title = "有效订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XsjjOrder xsjjOrder)
    {
        return toAjax(xsjjOrderService.updateXsjjOrder(xsjjOrder));
    }

    /**
     * 删除有效订单
     */
    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:remove')")
    @Log(title = "有效订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xsjjOrderService.deleteXsjjOrderByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('system:xsjjOrder:acquire')")
    @Log(title = "有效订单", businessType = BusinessType.EXPORT)
    @PostMapping("/acquire")
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult acquire(){

        XsjjOrder xsjjOrder = new XsjjOrder();
        //第三方实体类
        XsjjLitemallOrder xsjjLitemallOrder = new XsjjLitemallOrder();

        try {
            //清除历史数据 暂时没更好办法
            xsjjOrderService.deleteAllXsjjOrder();
            //查询有效订单集合
            List<XsjjLitemallOrder> listXlo = xsjjLitemallOrderService.selectVaildXsjjLitemallOrderList(xsjjLitemallOrder);
            //查询最大有效订单时间
//            List<XsjjOrder> listXo = xsjjOrderService.queryMaxAddTime(xsjjOrder);
//            Date Max_AddTime = DateUtils.parseDate("2020-01-01 00:00:00");
            for (int i = 0; i < listXlo.size(); i++){
                XsjjLitemallOrder xlo = listXlo.get(i);
//                if (listXo.size() > 0){
//                    Max_AddTime = listXo.get(0).getAddTime();
//                }
//                //时间对比，只有当有效订单集合中的订单时间大于最大有效订单时间，数据才会进行更新
//                if (xlo.getAddTime().getTime() > Max_AddTime.getTime()){
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
            return error("数据获取失败，报错如下" + e.getMessage());
        }
        return success("数据执行成功");
    }

    //获取两个List中的不同元素
//    private static List<String> getDiffrent4(List<XsjjLitemallOrder> list1, List<XsjjOrder> list2) {
//        List<XsjjLitemallOrder> diff = new ArrayList<XsjjLitemallOrder>();
//        long start = System.currentTimeMillis();
//        Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
//        List<XsjjLitemallOrder> maxList = list1;
//        List<XsjjOrder> minList = list2;
//        if (list2.size() > list1.size()) {
//            maxList = list2;
//            minList = list1;
//        }
//        for (String string : maxList) {
//            map.put(string, 1);
//        }
//        for (String string : minList) {
//            Integer count = map.get(string);
//            if (count != null) {
//                map.put(string, ++count);
//                continue;
//            }
//            map.put(string, 1);
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                diff.add(entry.getKey());
//            }
//        }
//        System.out.println("方法4 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
//        return diff;
//    }
}
