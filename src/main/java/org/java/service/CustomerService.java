package org.java.service;

import org.java.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    public List<Customer> getList(int page, int rows,String searchcustomerid);

    public int getCount(String searchcustomerid);
    public void updateCustomer(Customer e);
    public void add(Customer f);
    public void delCustomer(String customer_id);

}
