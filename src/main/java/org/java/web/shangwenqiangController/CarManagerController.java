package org.java.web.shangwenqiangController;

import org.java.entity.Car;
import org.java.entity.CarDispatch;
import org.java.service.CarManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author:
 * @Date: 2019/8/18 10:09
 * @Description: org.java.web.shangwenqiangController
 * ._ooOoo_                  .--,       .--,
 * o8888888o                ( (  \.---./  ) )
 * 88" . "88                '.__/o   o\__.'
 * (| -_- |)                   {=  ^  =}
 * O\ = /O                      >  -  <
 * _/`---'\___                 /       \
 * _/`---'\_____              //       \\
 * .' \\| |// `.             //|   .   |\\
 * / \\||| : |||// \         "'\       /'"_.-~^`'-.
 * / _||||| -:- |||||- \        \  _  /--'         `
 * | | \\\ - /// | |          ___)( )(___
 * | \_| ''\---/'' | |       (((__) (__)))
 */
@RestController
public class CarManagerController {
    @Autowired
    private CarManagerService carManagerService;
    @GetMapping("initCarManager")
    public Map getList(Integer page, Integer limit, Integer carId){

        //创建一个map，用于封装要返回的4种数据
        Map map = new HashMap();

        List<Car> list = carManagerService.findCarManager(page,limit,carId);//集合
        int count = carManagerService.getCarManagerCount(carId);//总数

        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",count );//总数
        map.put("data",list );

        return map;
    }

    @RequestMapping("/carManagerAdd")
    @ResponseBody //一定要添加此注解
    public void add(Car c){
        carManagerService.add(c);
    }

    @RequestMapping("/carManagerUpdate")
    @ResponseBody //一定要添加此注解
    public void update(Car c){
        System.out.println("#########################");
        carManagerService.update(c);
    }
    @RequestMapping("/carManager/{carManagerDel}")
    @ResponseBody //一定要添加此注解
    public void del(Integer carId, @PathVariable String carManagerDel){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+carId);
        carManagerService.del(carId);
    }
}
