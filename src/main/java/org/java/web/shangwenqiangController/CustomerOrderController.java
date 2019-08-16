package org.java.web.shangwenqiangController;

import org.java.entity.ArriveNoticeOrder;
import org.java.entity.CustomerOrder;
import org.java.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 13:59
 * @Description:
 */
@RestController
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;
    @GetMapping("/initCustomerOrder")
    public Map findPurchaseOrder(Integer page , Integer limit , String customerOrderId){
        Map map = new HashMap();
        List<CustomerOrder> list = customerOrderService.findCustomerOrder(page,limit,customerOrderId);
        int count =customerOrderService.getCustomerOrderCount(customerOrderId);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        System.out.println(customerOrderId);
        return map;

    }
}
