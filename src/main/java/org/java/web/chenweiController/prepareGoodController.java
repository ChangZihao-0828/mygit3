package org.java.web.chenweiController;

import org.java.entity.PrepareGoods;
import org.java.entity.Supplier;
import org.java.service.PrepareGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *  * $methodName$
 * $params$
 *  * @Description 方法描述,必填  <br/>
 *  * @return $return$
 *  * @throw $throw$ 
 *  * @author 陈威
 *  * @createTime $date$ $time$
 *  * @Version V1.0.0
 *  
 */
@Controller
public class prepareGoodController {
    @Autowired
    private PrepareGoodsService prepareGoodsService;

    @ResponseBody
    @RequestMapping("PrepareGoods")
    public Map getList(Integer page, Integer limit,String prepareGoodsId) {
        Map map = new HashMap();

        List<PrepareGoods> list = prepareGoodsService.getList(page, limit,prepareGoodsId);//集合
        int count = prepareGoodsService.getCount();//总数

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", list);

        return map;
    }

    @RequestMapping("delPrepareGoods")
    @ResponseBody
    public void delPrepareGoods(String prepareGoodsId) {

        prepareGoodsService.delPrepareGoods1(prepareGoodsId);
    }
    @RequestMapping("PrepareGoodsadd")
    @ResponseBody //一定要添加此注解
    public void edit(PrepareGoods e) {
        if (e.getPrepareGoodsId() == "") {
            e.setPrepareGoodsId(String.valueOf(UUID.randomUUID()));
            prepareGoodsService.add(e);
        } else {
            prepareGoodsService.updateSupplier(e);
        }
    }
    @RequestMapping("pg1")
    public String cg1() {

        return "customer/arrival_advice";
    }
}
