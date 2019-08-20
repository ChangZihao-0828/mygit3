package org.java.service;

import org.java.entity.OutGoods;
import org.java.entity.TakeGoods;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 10:43
 * @Description: Frighting!!!
 */


public interface TakeGoodsService {

    public void addTakeGoods(TakeGoods takeGoods);

    public List<TakeGoods> findTakeGoods(Integer page, Integer rows, String searchTakeGoodsId);

    public Integer findTakeGoodsCount(String searchTakeGoodsId);
}
