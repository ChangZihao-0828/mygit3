package org.java.service;

import org.java.entity.ArriveNoticeOrder;
import org.java.entity.InGoods;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 11:16
 * @Description:
 */
public interface InGoodsService {
    public List<InGoods> findInGoods(int page, int rows, String inGoodsId);

    public int getInGoodsCount(String inGoodsId);
}
