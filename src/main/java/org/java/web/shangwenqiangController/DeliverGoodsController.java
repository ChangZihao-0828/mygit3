package org.java.web.shangwenqiangController;

import org.java.entity.CustomerOrder;
import org.java.entity.DeliverGoods;
import org.java.entity.OutGoods;
import org.java.service.CustomerOrderService1;
import org.java.service.DeliverGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 12:50
 * @Description:
 */
@RestController
public class DeliverGoodsController {

    @Autowired
    private DeliverGoodsService deliverGoodsService;

    @Autowired
    private CustomerOrderService1 customerOrderService1;

    @GetMapping("/initDeliverGoods")
    @ResponseBody
    public Map findPurchaseOrder(Integer page , Integer limit , String deliverGoodsId){

        Map map = new HashMap();

        List<DeliverGoods> list = deliverGoodsService.findDeliverGoods(page,limit,deliverGoodsId);

        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);

        return map;

    }

    @GetMapping("/initDeliverGoods2")
    @ResponseBody
    public Map findPurchaseOrder2(){

        Map map = new HashMap();

        List<DeliverGoods> list = deliverGoodsService.findDeliverGoods2();

        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);

        return map;

    }

    @PostMapping("submitDeliveryOrder")
    @ResponseBody
    public void submitDeliveryOrder(String deliverGoodsTaskid,String deliverGoodsId){

        deliverGoodsService.submitDeliveryOrder(deliverGoodsTaskid);

        DeliverGoods deliverGoods = new DeliverGoods();

        deliverGoods.setDeliverGoodsId(deliverGoodsId);

        deliverGoods.setDeliverGoodsStatus("未调度");

        deliverGoodsService.updateState(deliverGoods);

    }

    @RequestMapping("/deliverAdd")
    @ResponseBody //一定要添加此注解
    public void add(DeliverGoods d){

        deliverGoodsService.add(d);

        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setCustomerOrderId(d.getCustomerOrderId());

        customerOrder.setCustomerOrderState("配送作业中");

        customerOrderService1.updateCustomerOrderState(customerOrder);
    }

    @RequestMapping("/deliverUpdate")
    @ResponseBody //一定要添加此注解
    public void update(DeliverGoods d){

        deliverGoodsService.update(d);
    }

    @RequestMapping("/deliver/{deliverDel}")
    @ResponseBody //一定要添加此注解
    public void del(String deliverGoodsId, @PathVariable String deliverDel){

        deliverGoodsService.del(deliverGoodsId);
    }


}

