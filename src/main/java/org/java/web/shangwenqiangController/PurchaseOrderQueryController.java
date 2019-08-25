package org.java.web.shangwenqiangController;

import org.java.entity.PurchaseAppllyOrder;
import org.java.entity.PurchaseOrder;
import org.java.service.PurchaseAppllyOrderService;
import org.java.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 00:01
 * @Description:
 */
@RestController
public class PurchaseOrderQueryController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private PurchaseAppllyOrderService purchaseAppllyOrderService;

    @GetMapping("/initPurchaseOrder")
    public Map findPurchaseOrder(Integer page , Integer limit , String purchaseOrderId){
        Map map = new HashMap();
        List<PurchaseOrder> list = purchaseOrderService.findPurchaseOrder(page,limit,purchaseOrderId);
        int count =purchaseOrderService.getPurchaseOrderCount(purchaseOrderId);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        System.out.println(purchaseOrderId);
        return map;

    }

    @GetMapping("/findGroupPurchaseApplyOrder")
    public Map findGroupPurchaseApplyOrder(Integer page , Integer limit , String purchaseOrderId){
        Map map = new HashMap();

        List<PurchaseAppllyOrder> list = purchaseAppllyOrderService.findGroupPurchaseApplyOrder();

        int count =purchaseAppllyOrderService.findGroupPurchaseApplyOrderCount();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;

    }
}
