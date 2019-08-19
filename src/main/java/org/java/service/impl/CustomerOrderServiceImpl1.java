package org.java.service.impl;

import org.java.dao.CustomerOrderMapper1;
import org.java.entity.CustomerOrder;
import org.java.service.CustomerOrderService;
import org.java.service.CustomerOrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/17 15:10
 * @Description: Frighting!!!
 */

@Service
public class CustomerOrderServiceImpl1 implements CustomerOrderService1 {

    @Autowired
    private CustomerOrderMapper1 customerOrderMapper;


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
