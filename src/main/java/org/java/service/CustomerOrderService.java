package org.java.service;

import org.java.entity.ArriveNoticeOrder;
import org.java.entity.CustomerOrder;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 13:54
 * @Description:
 */
public interface CustomerOrderService {
    public List<CustomerOrder> findCustomerOrder(int page, int rows, String customerOrderId);

    public int getCustomerOrderCount(String customerOrderId);
}
