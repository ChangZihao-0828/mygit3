package org.java.service;

import org.java.entity.OutEquipGoods;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 10:44
 * @Description: Frighting!!!
 */


public interface OutEquipGoodsService {

    public void addOutEquipGoods(OutEquipGoods outEquipGoods);

    public List<OutEquipGoods> findOutEquipGoods(Integer page, Integer rows, String searchOutEquipGoodsId);

    public Integer findOutEquipGoodsCount(String searchOutEquipGoodsId);
}
