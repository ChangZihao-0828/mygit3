package org.java.service;

<<<<<<< HEAD
=======
import org.java.entity.ArriveNoticeOrder;
>>>>>>> origin/master
import org.java.entity.CustomerOrder;

import java.util.List;

<<<<<<< HEAD
public interface CustomerOrderService {
    public List<CustomerOrder> getList(int page, int rows);

    public int getCount();

    public void add(CustomerOrder f);
=======
/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 13:54
 * @Description:
 */
public interface CustomerOrderService {
    public List<CustomerOrder> findCustomerOrder(int page, int rows, String customerOrderId);

    public int getCustomerOrderCount(String customerOrderId);
>>>>>>> origin/master
}
