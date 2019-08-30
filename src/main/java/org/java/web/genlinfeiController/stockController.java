package org.java.web.genlinfeiController;

import org.java.dao.InGoodsMapper;
import org.java.entity.*;
import org.java.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class stockController {

    @Autowired
    private OutGoodsService outGoodsService;

    @Autowired
    private TakeGoodsService takeGoodsService;

    @Autowired
    private OutEquipGoodsService outEquipGoodsService;

    @Autowired
    private InGoodsService inGoodsService;

    @Autowired
    private DeliverGoodsService deliverGoodsService;

    @Autowired
    private CustomerOrderService1 customerOrderService1;

    @GetMapping("/stock/{page}")
    public String stock(@PathVariable("page") String page){

        return "stock/"+page;
    }

    @RequestMapping("deliveryReceiving")
    @ResponseBody
    public Map<String,Object> deliveryReceiving(Integer page,Integer limit, String searchDeliveryReceivingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoods(page,limit,searchDeliveryReceivingId,null);

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",outGoods.size());//总数
        map.put("data",outGoods);

        return map;
    }

    @RequestMapping("deliveryReceiving2")
    @ResponseBody
    public Map<String,Object> deliveryReceiving2(Integer page,Integer limit, String searchDeliveryReceivingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoods2();

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",outGoods.size());//总数
        map.put("data",outGoods);

        return map;
    }


    @PostMapping("submitOutGoodsOrder")
    @ResponseBody
    public void submitDeliveryOrder(String outGoodsTaskid,String outGoodsId){

        deliverGoodsService.submitDeliveryOrder(outGoodsTaskid);

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(outGoodsId);

        outGoods.setOutGoodsStatus("未拣选");

        outGoodsService.updateOutGoodsStatus(outGoods);

    }

    @RequestMapping("deliveryOrder")
    @ResponseBody
    public Map<String,Object> deliveryOrder(Integer page,Integer limit, String searchDeliveryOrderId){

        List<OutGoods> outGoods = outGoodsService.findOutGoodsByProcessinstanceId("已装卸");

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",outGoods.size());//总数
        map.put("data",outGoods);
        return map;
    }


    @RequestMapping("deliveryPicking")
    @ResponseBody
    public Map<String,Object> deliveryPicking(Integer page,Integer limit, String searchDeliveryPickingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoodsByProcessinstanceId("未拣选");


        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",outGoods.size());//总数
        map.put("data",outGoods);
        return map;
    }

    @RequestMapping("deliveryUnloading")
    @ResponseBody
    public Map<String,Object> deliveryUnloading(Integer page,Integer limit, String searchDeliveryUnloadingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoodsByProcessinstanceId("已拣货");

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",outGoods.size());//总数
        map.put("data",outGoods);
        return map;
    }





    @PostMapping("addDeliveryReceiving")
    @ResponseBody
    public void addDeliveryReceiving(OutGoods outGoods){

        outGoodsService.addDeliveryReceiving(outGoods);

    }

    @PostMapping("addDeliveryPicking")
    @ResponseBody
    public void addDeliveryPicking(TakeGoods takeGoods){

        takeGoodsService.addTakeGoods(takeGoods);

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(takeGoods.getOutGoodsId());

        outGoods.setOutGoodsStatus("已拣货");

        outGoodsService.updateOutGoodsStatus(outGoods);


    }

    @PostMapping("addDeliveryUnloading")
    @ResponseBody
    public void addDeliveryUnloading(OutEquipGoods outEquipGoods){

        outEquipGoodsService.addOutEquipGoods(outEquipGoods);

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(outEquipGoods.getOutGoodsId());

        outGoods.setOutGoodsStatus("已装卸");

        outGoodsService.updateOutGoodsStatus(outGoods);


    }

    @PostMapping("addDeliveryOrder")
    @ResponseBody
    public void addDeliveryOrder(String id,String taskId,String customerOrderId){

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(id);

        outGoods.setOutGoodsStatus("已出库");

        outGoodsService.updateOutGoodsStatus(outGoods);

        deliverGoodsService.submitDeliveryOrder(taskId);

        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setCustomerOrderId(customerOrderId);

        customerOrder.setCustomerOrderState("运输中");

        customerOrderService1.updateCustomerOrderState(customerOrder);


    }


    @GetMapping("incomingOrders")
    @ResponseBody
    public Map<String,Object> incomingOrders(Integer page,Integer limit, String searchIncomingOrdersId){

        List<InGoods> inGoods = inGoodsService.findInGoods(page,limit,searchIncomingOrdersId);

        Integer count = inGoodsService.getInGoodsCount(searchIncomingOrdersId);

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",count);//总数
        map.put("data",inGoods);

        return map;
    }
}
