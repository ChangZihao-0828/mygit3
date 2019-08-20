package org.java.service;

import org.java.entity.ArriveNoticeOrder;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 10:06
 * @Description:
 */
public interface ArriveNoticeOrderService {
    public List<ArriveNoticeOrder> findArriveNoticeOrder(int page, int rows, String arriveNoticeOrderId);

    public int getArriveNoticeOrderCount(String arriveNoticeOrderId);
    public void add(ArriveNoticeOrder e);
    public int delArriveNoticeOrder(String arriveNoticeOrderId);
    public void updateArriveNoticeOrder(ArriveNoticeOrder e);
}
