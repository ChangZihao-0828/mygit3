package org.java.service.impl;

import org.java.dao.CustomerOrderMapper;
import org.java.dao.SupplierMapper;
import org.java.entity.Customer;
import org.java.entity.CustomerOrder;
import org.java.service.CustomerOrderService;
import org.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderMapper customerOrderMapper;


    @Override
    public List<CustomerOrder> getList(int page, int rows) {
        int start = (page-1)*rows;
        return customerOrderMapper.getList(0,4);
    }

    @Override
    public int getCount() {
        return customerOrderMapper.getCount();
    }
    @Transactional
    @Override
    public void add(CustomerOrder f) {
        customerOrderMapper.insert(f);
    }
}
