package org.java.web.shangwenqiangController;

import org.java.entity.CarDeployLine;
import org.java.entity.CarDispatch;
import org.java.entity.DeliverGoods;
import org.java.service.CarDeployLineService;
import org.java.service.CarDispatchService;
import org.java.service.DeliverGoodsService;
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

    @Autowired
    private CarDispatchService carDispatchService;

    @Autowired
    private DeliverGoodsService deliverGoodsService;

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

    @GetMapping("carDeployLine")
    public Map carDeployLine(){

        //创建一个map，用于封装要返回的4种数据
        Map map = new HashMap();

        List<DeliverGoods> list = carDispatchService.finddeliverGoodsByProcessinstanceId("未配线");

        map.put("code", 0);//状态正常
        map.put("msg","" );
        map.put("count",list.size() );//总数
        map.put("data",list );

        return map;
    }

    @RequestMapping("/carDeployAdd")
    @ResponseBody //一定要添加此注解
    public void add(CarDeployLine c){

        carDeployLineService.add(c);

        DeliverGoods deliverGoods = new DeliverGoods();

        deliverGoods.setDeliverGoodsId(c.getDeliverGoodsId());

        deliverGoods.setDeliverGoodsStatus("已配线");

        deliverGoodsService.updateState(deliverGoods);
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

        carDeployLineService.del(carDeployLineId);
    }
    @RequestMapping("/carFromSiteUpdate")
    @ResponseBody //一定要添加此注解
    public void updateCarFromSite(CarDeployLine c){

        carDeployLineService.UpdateCarFromSite(c);
    }
    @RequestMapping("/carFromSiteUpdateIn")
    @ResponseBody //一定要添加此注解
    public void updateCarFromSiteIn(CarDeployLine c){

        carDeployLineService.UpdateCarFromSiteIn(c);
    }

}
