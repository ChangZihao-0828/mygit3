package org.java.web.genlinfeiController;

import org.java.dao.InGoodsMapper;
import org.java.entity.InGoods;
import org.java.entity.OutEquipGoods;
import org.java.entity.OutGoods;
import org.java.entity.TakeGoods;
import org.java.service.InGoodsService;
import org.java.service.OutEquipGoodsService;
import org.java.service.OutGoodsService;
import org.java.service.TakeGoodsService;
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

    @GetMapping("/stock/{page}")
    public String stock(@PathVariable("page") String page){

        return "stock/"+page;
    }

    @RequestMapping("deliveryReceiving")
    @ResponseBody
    public Map<String,Object> deliveryReceiving(Integer page,Integer limit, String searchDeliveryReceivingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoods(page,limit,searchDeliveryReceivingId,null);

        Integer count = outGoodsService.findOutGoodsCount(searchDeliveryReceivingId,null);

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",count);//总数
        map.put("data",outGoods);

        return map;
    }

    @RequestMapping("deliveryOrder")
    @ResponseBody
    public Map<String,Object> deliveryOrder(Integer page,Integer limit, String searchDeliveryOrderId){

        List<OutGoods> outGoods = outGoodsService.findOutGoods(page,limit,searchDeliveryOrderId,"已装卸");

        Integer count = outGoodsService.findOutGoodsCount(searchDeliveryOrderId,"已装卸");

        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",count);//总数
        map.put("data",outGoods);
        return map;
    }

    @RequestMapping("deliveryPicking")
    @ResponseBody
    public Map<String,Object> deliveryPicking(Integer page,Integer limit, String searchDeliveryPickingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoods(page,limit,searchDeliveryPickingId,"未接收");

        Integer count = outGoodsService.findOutGoodsCount(searchDeliveryPickingId,"未接收");


        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",count);//总数
        map.put("data",outGoods);
        return map;
    }

    @RequestMapping("deliveryUnloading")
    @ResponseBody
    public Map<String,Object> deliveryUnloading(Integer page,Integer limit, String searchDeliveryUnloadingId){

        List<OutGoods> outGoods = outGoodsService.findOutGoods(page,limit,searchDeliveryUnloadingId,"已拣选");

        Integer count = outGoodsService.findOutGoodsCount(searchDeliveryUnloadingId,"已拣选");


        Map map = new HashMap();
        map.put("code",0);//状态正常
        map.put("msg","");
        map.put("count",count);//总数
        map.put("data",outGoods);
        return map;
    }

    @PostMapping("addDeliveryReceiving")
    @ResponseBody
    public void addDeliveryReceiving(OutGoods outGoods){

        outGoods.setOutGoodsId(String.valueOf(UUID.randomUUID()));

        outGoods.setOutGoodsStatus("未接收");

        outGoodsService.addDeliveryReceiving(outGoods);


    }

    @PostMapping("addDeliveryPicking")
    @ResponseBody
    public void addDeliveryPicking(TakeGoods takeGoods){

        takeGoods.setTakeGoodsId(String.valueOf(UUID.randomUUID()));

        takeGoodsService.addTakeGoods(takeGoods);

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(takeGoods.getOutGoodsId());

        outGoods.setOutGoodsStatus("已拣选");

        outGoodsService.updateOutGoodsStatus(outGoods);


    }

    @PostMapping("addDeliveryUnloading")
    @ResponseBody
    public void addDeliveryUnloading(OutEquipGoods outEquipGoods){

        outEquipGoods.setOutEquipGoodsId(String.valueOf(UUID.randomUUID()));

        outEquipGoods.setOutEquipGoodsStatus("已装卸");

        outEquipGoodsService.addOutEquipGoods(outEquipGoods);

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(outEquipGoods.getOutGoodsId());

        outGoods.setOutGoodsStatus("已装卸");

        outGoodsService.updateOutGoodsStatus(outGoods);


    }

    @PostMapping("addDeliveryOrder")
    @ResponseBody
    public void addDeliveryOrder(String id){

        OutGoods outGoods = new OutGoods();

        outGoods.setOutGoodsId(id);

        outGoods.setOutGoodsStatus("已出库");

        outGoodsService.updateOutGoodsStatus(outGoods);

    }


    @GetMapping("incomingOrders")
    @ResponseBody
    public Map<String,Object> incomingOrders(Integer page,Integer limit, String searchIncomingOrdersId){
        System.out.println("------------"+searchIncomingOrdersId);
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
