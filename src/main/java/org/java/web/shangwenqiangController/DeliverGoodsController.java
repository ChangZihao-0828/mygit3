package org.java.web.shangwenqiangController;

import org.java.entity.DeliverGoods;
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
    @GetMapping("/initDeliverGoods")
    public Map findPurchaseOrder(Integer page , Integer limit , String deliverGoodsId){
        Map map = new HashMap();
        List<DeliverGoods> list = deliverGoodsService.findDeliverGoods(page,limit,deliverGoodsId);
        int count =deliverGoodsService.getDeliverGoodsCount(deliverGoodsId);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        System.out.println(deliverGoodsId);
        return map;

    }
    @RequestMapping("/deliverAdd")
    @ResponseBody //一定要添加此注解
    public void add(DeliverGoods d){
        deliverGoodsService.add(d);
    }

    @RequestMapping("/deliverUpdate")
    @ResponseBody //一定要添加此注解
    public void update(DeliverGoods d){
        System.out.println("#########################");
        deliverGoodsService.update(d);
    }

    @RequestMapping("/deliver/{deliverDel}")
    @ResponseBody //一定要添加此注解
    public void del(String deliverGoodsId, @PathVariable String deliverDel){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+deliverGoodsId);
        deliverGoodsService.del(deliverGoodsId);
    }


}

