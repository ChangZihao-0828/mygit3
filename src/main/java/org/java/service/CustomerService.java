package org.java.service;

import org.java.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    public List<Customer> getList(int page, int rows);

    public int getCount();

    public void add(Customer f);

}
