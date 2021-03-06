package org.java.service;

import org.java.entity.ArriveNoticeOrder;
import org.java.entity.DeliverGoods;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 12:44
 * @Description:
 */
public interface DeliverGoodsService {

    public List<DeliverGoods> findDeliverGoods(int page, int rows, String deliverGoodsId);

    public List<DeliverGoods> findDeliverGoods2();

    public int getDeliverGoodsCount(String deliverGoodsId);

    public void add(DeliverGoods d);

    public void update(DeliverGoods d);

    public void updateState(DeliverGoods deliverGoods);

    public void del(String deliverGoodsId);

    public void submitDeliveryOrder(String deliverGoodsTaskid);

}
