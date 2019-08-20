package org.java.web.shangwenqiangController;

import org.java.entity.CarDispatch;
import org.java.service.CarDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author: 商文强
 * @Date: 2019/8/17 21:51
 * @Description: org.java.web.shangwenqiangController
 * _ooOoo_               .--,       .--,
 * o888888o             ( (  \.---./  ) )
 * 88" . "88             '.__/o   o\__.'
 * (| -_- |)                {=  ^  =}
 * O\ = /O                   >  -  <
 * _/`---'\___              /       \
 * _/`---'\_____           //       \\
 * .' \\| |// `.          //|   .   |\\
 * / \\||| : |||// \      "'\       /'"_.-~^`'-.
 * / _||||| -:- |||||- \     \  _  /--'         `
 * | | \\\ - /// | |       ___)( )(___
 * | \_| ''\---/'' | |    (((__) (__)))
 */
@RestController
public class CarDispatchController {
    @Autowired
    private CarDispatchService carDispatchService;
    @GetMapping("initCarDispatch")
    public Map getList(Integer page,Integer limit,String carDispatchId){

        //创建一个map，用于封装要返回的4种数据
        Map map = new HashMap();

        List<CarDispatch> list = carDispatchService.findCarDispatch(page,limit,carDispatchId);//集合
        int count = carDispatchService.getCarDispatchCount(carDispatchId);//总数

        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",count );//总数
        map.put("data",list );

        return map;
    }

    @RequestMapping("/dispatchAdd")
    @ResponseBody //一定要添加此注解
    public void add(CarDispatch d){
        carDispatchService.add(d);
    }

    @RequestMapping("/dispatchUpdate")
    @ResponseBody //一定要添加此注解
    public void update(CarDispatch c){
        System.out.println("#########################");
        carDispatchService.update(c);
    }
    @RequestMapping("/carDispatch/{dispatchDel}")
    @ResponseBody //一定要添加此注解
    public void del(String carDispatchId, @PathVariable String dispatchDel){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+carDispatchId);
        carDispatchService.del(carDispatchId);
    }
}
