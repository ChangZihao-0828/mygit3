package org.java.web.shangwenqiangController;

import org.java.entity.ArriveNoticeOrder;
import org.java.service.ArriveNoticeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 00:01
 * @Description:
 */
@RestController
public class ArriveNoticeOrderController {
    @Autowired
    private ArriveNoticeOrderService arriveNoticeOrderService;

    @GetMapping("/initNotice")
    public Map findPurchaseOrder(Integer page , Integer limit , String arriveNoticeOrderId){
        Map map = new HashMap();
        List<ArriveNoticeOrder> list = arriveNoticeOrderService.findArriveNoticeOrder(page,limit,arriveNoticeOrderId);
        int count =arriveNoticeOrderService.getArriveNoticeOrderCount(arriveNoticeOrderId);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        System.out.println(arriveNoticeOrderId);
        return map;

    }
    @RequestMapping("delArriveNoticeOrder")
    @ResponseBody
    public void delArriveNoticeOrder(String arriveNoticeOrderId) {

        arriveNoticeOrderService.delArriveNoticeOrder(arriveNoticeOrderId);
    }
    @RequestMapping("ArriveNoticeOrdersadd")
    @ResponseBody //一定要添加此注解
    public void edit(ArriveNoticeOrder e) {
        if (e.getArriveNoticeOrderId() == "") {
            e.setArriveNoticeOrderId(String.valueOf(UUID.randomUUID()));
            arriveNoticeOrderService.add(e);
        } else {
            arriveNoticeOrderService.updateArriveNoticeOrder(e);
        }
    }
}
