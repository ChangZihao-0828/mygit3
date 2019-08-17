package org.java.web.chenweiController;

import org.java.entity.Customer;
import org.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;


    @ResponseBody
    @RequestMapping("op")//显示数据库全部数据的请求
    public Map getList(Integer page,Integer limit){
        Map map = new HashMap();
        List<Customer> list =service.getList(page,limit);//集合
        int count =service.getCount();//总数
        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",count );//总数
        map.put("data",list );

        return map;
    }
    @RequestMapping("pl")//查看全部数据的的请求
    public String pl(){


        return "customer/Customer_Information_Management";
    }

    @RequestMapping("op1")//将表单数据添加的请求
    @ResponseBody
    public void op1(Customer f){

        service.add(f);
    }
    @RequestMapping("op3")
    public String op3(){

        return "customer/order_processing";
    }
    @RequestMapping("op4")//跳转到订单跟踪页面
    public String op4(){

        return "customer/Brand_Manage";
    }
    @RequestMapping("op5")//调到订单接收页面
    public String op5(){

        return "customer/Category_Manage";
    }

}
