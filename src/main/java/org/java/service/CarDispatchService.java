package org.java.service;

import org.java.entity.ArriveNoticeOrder;
import org.java.entity.CarDispatch;
import org.java.entity.DeliverGoods;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/17 20:36
 * @Description:
 */
public interface CarDispatchService {
    public List<CarDispatch> findCarDispatch(int page, int rows, String carDispatchId);

    public int getCarDispatchCount(String carDispatchId);

    public void add(CarDispatch c);

    public void update(CarDispatch c);

    public void del(String id);

    public List<DeliverGoods> finddeliverGoodsByProcessinstanceId(String state);
}
