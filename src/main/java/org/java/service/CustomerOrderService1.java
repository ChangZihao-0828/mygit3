package org.java.service;

import org.java.entity.CustomerOrder;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/17 15:09
 * @Description: Frighting!!!
 */


public interface CustomerOrderService1 {

    public List<CustomerOrder> getList(int page, int rows);

    public int getCount();

    public void add(CustomerOrder f);

    public void acceptCustomerOrder(CustomerOrder customerOrder);
}
