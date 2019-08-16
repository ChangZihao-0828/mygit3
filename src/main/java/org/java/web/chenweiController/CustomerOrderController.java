package org.java.web.chenweiController;

import org.java.entity.CustomerOrder;
import org.java.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;
    @ResponseBody
    @RequestMapping("order")//显示数据库全部数据的请求
    public Map getList(Integer page, Integer limit){
        Map map = new HashMap();
        List<CustomerOrder> list =customerOrderService.getList(page,limit);//集合
        int count =customerOrderService.getCount();//总数
        System.out.println("---------");
        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",count );//总数
        map.put("data",list );

        return map;
    }
}
