package org.java.web.shangwenqiangController;

import org.java.entity.CarDeployLine;
import org.java.service.CarDeployLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author:
 * @Date: 2019/8/18 00:14
 * @Description: org.java.web.shangwenqiangController
 * _ooOoo_                  .--,       .--,
 * o888888o                ( (  \.---./  ) )
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
public class CarDeployLineController {
    @Autowired
    private CarDeployLineService carDeployLineService;
    @GetMapping("initCarDeployLine")
    public Map getList(Integer page,Integer limit,String carDeployLineId){

        //创建一个map，用于封装要返回的4种数据
        Map map = new HashMap();

        List<CarDeployLine> list = carDeployLineService.findCarDeployLine(page,limit,carDeployLineId);//集合
        int count = carDeployLineService.getCarDeployLineCount(carDeployLineId);//总数

        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",count );//总数
        map.put("data",list );

        return map;
    }

    @RequestMapping("/carDeployAdd")
    @ResponseBody //一定要添加此注解
    public void add(CarDeployLine c){
        carDeployLineService.add(c);
    }

    @RequestMapping("/carDeployUpdate")
    @ResponseBody //一定要添加此注解
    public void update(CarDeployLine c){
        System.out.println("#########################");
        carDeployLineService.update(c);
    }

    @RequestMapping("/carDeployLine/{carDeployDel}")
    @ResponseBody //一定要添加此注解
    public void del(String carDeployLineId, @PathVariable String carDeployDel){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+carDeployLineId);
        carDeployLineService.del(carDeployLineId);
    }

}
