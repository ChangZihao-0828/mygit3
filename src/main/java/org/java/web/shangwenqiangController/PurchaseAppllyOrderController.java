package org.java.web.shangwenqiangController;

import org.java.entity.PurchaseAppllyOrder;
import org.java.service.PurchaseAppllyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/15 13:46
 * @Description:
 */
@RestController
public class PurchaseAppllyOrderController {

    @Autowired
    private PurchaseAppllyOrderService purchaseAppllyOrderService;

    @GetMapping("/initPurchaseAppllyOrder")
    public Map findPurchaseAppllyOrder(Integer page ,Integer limit ,Integer purchaseAppllyUserName){
         Map map = new HashMap();

        List<PurchaseAppllyOrder> list = purchaseAppllyOrderService.findPurchaseAppllyOrder(page,limit,purchaseAppllyUserName);

        int count =purchaseAppllyOrderService.getCount(purchaseAppllyUserName);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;

    }

    @GetMapping("/initPurchaseAppllyOrderAll")
    public Map findPurchaseAppllyOrderAll(Integer page ,Integer limit ,Integer purchaseAppllyUserName){
        Map map = new HashMap();

        List<PurchaseAppllyOrder> list = purchaseAppllyOrderService.findPurchaseAppllyOrderAll(page,limit,purchaseAppllyUserName);

        int count =purchaseAppllyOrderService.findCount(purchaseAppllyUserName);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;

    }
    @RequestMapping("/add")
    @ResponseBody
    public void add(PurchaseAppllyOrder p){
       purchaseAppllyOrderService.add(p);
    }
    @RequestMapping("/update")
    @ResponseBody
    public void update(PurchaseAppllyOrder p){
        purchaseAppllyOrderService.update(p);
    }
    @RequestMapping("/del")
    @ResponseBody
    public void del(String purchaseAppllyOrderId){
        purchaseAppllyOrderService.del(purchaseAppllyOrderId);
    }
}
