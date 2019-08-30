
package org.java.web.chenweiController;

import org.java.entity.CustomerOrder;
import org.java.service.CustomerOrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class CustomerOrderController1 {

    @Autowired
    private CustomerOrderService1 customerOrderService1;

    @ResponseBody
    @RequestMapping("order")//显示数据库全部数据的请求
    public Map getList(Integer page, Integer limit){
        Map map = new HashMap();
        List<CustomerOrder> list =customerOrderService1.getList("未接收");//集合

        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",list.size());//总数
        map.put("data",list );

        return map;
    }

    @GetMapping("orderPeocessing")
    @ResponseBody
    public Map orderPeocessing(Integer page, Integer limit){

        Map map = new HashMap();
        List<CustomerOrder> list =customerOrderService1.getList("已接收");//集合

        System.out.println(list+","+list.size());

        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",list.size());//总数
        map.put("data",list );

        return map;

    }

    @PostMapping("acceptCustomerOrder")
    @ResponseBody
    private void acceptCustomerOrder(CustomerOrder customerOrder){

        customerOrderService1.acceptCustomerOrder(customerOrder);

    }
}
