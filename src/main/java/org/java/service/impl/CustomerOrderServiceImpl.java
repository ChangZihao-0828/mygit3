package org.java.service.impl;

import org.java.dao.CustomerOrderMapper;
<<<<<<< HEAD
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
=======
import org.java.entity.CustomerOrder;
import org.java.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 13:55
 * @Description:
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderMapper mapper;
    @Override
    public List<CustomerOrder> findCustomerOrder(int page, int rows, String customerOrderId) {
        int start = (page - 1) * rows;

        return mapper.findCustomerOrder(start,rows,customerOrderId);
    }

    @Override
    public int getCustomerOrderCount(String customerOrderId) {
        return mapper.getCustomerOrderCount(customerOrderId);
>>>>>>> origin/master
    }
}
