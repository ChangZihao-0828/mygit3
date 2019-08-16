package org.java.web.shangwenqiangController;

import org.java.entity.InGoods;
import org.java.service.InGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 11:44
 * @Description:
 */
@RestController
public class InGoodsController {
    @Autowired
    private InGoodsService inGoodsService;
    @GetMapping("/initWarehouseEntry")
    public Map findPurchaseAppllyOrder(Integer page , Integer limit , String inGoodsId){
        Map map = new HashMap();
        List<InGoods> list = inGoodsService.findInGoods(page,limit,inGoodsId);
        int count =inGoodsService.getInGoodsCount(inGoodsId);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        System.out.println(inGoodsId);
        return map;

    }

    }

