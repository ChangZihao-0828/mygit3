package org.java.service.impl;

import org.java.dao.CustomerOrderMapper;
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
    }
}
