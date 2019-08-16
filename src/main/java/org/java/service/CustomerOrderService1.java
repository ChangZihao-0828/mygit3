package org.java.service;

import org.java.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService1 {
    public List<CustomerOrder> getList(int page, int rows);

    public int getCount();

    public void add(CustomerOrder f);
}
