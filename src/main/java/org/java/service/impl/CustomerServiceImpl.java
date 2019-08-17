package org.java.service.impl;

import org.java.dao.CustomerMapper;
import org.java.entity.Customer;
import org.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getList(int page, int rows) {
        int start = (page-1)*rows;
        return customerMapper.getList(0,4);
    }

    @Override
    public int getCount() {
        return customerMapper.getCount();
    }

    @Transactional
    @Override
    public void add(Customer f) {
        customerMapper.insert(f);
    }


}
