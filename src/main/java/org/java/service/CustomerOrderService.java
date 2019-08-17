package org.java.service;

import org.java.entity.CustomerOrder;

import java.util.List;


public interface CustomerOrderService {
    public List<CustomerOrder> findCustomerOrder(int page, int rows, String customerOrderId);

    public int getCustomerOrderCount(String customerOrderId);
}
