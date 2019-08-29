package org.java.service;

import org.java.entity.OutGoods;
import org.java.entity.TakeGoods;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 09:27
 * @Description: Frighting!!!
 */


public interface OutGoodsService {

    public void addDeliveryReceiving(OutGoods outGoods);

    public List<OutGoods> findOutGoods(Integer page, Integer rows, String searchDeliveryReceivingId,String outGoodsStatus);

    public Integer findOutGoodsCount(String searchDeliveryReceivingId,String outGoodsStatus);

    public void updateOutGoodsStatus(OutGoods record);

    public List<OutGoods> findOutGoodsByProcessinstanceId(String state);

    public List<OutGoods> findOutGoods2();


}
