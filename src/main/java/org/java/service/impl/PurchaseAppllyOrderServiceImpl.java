package org.java.service.impl;

import org.java.dao.PurchaseAppllyOrderMapper;
import org.java.entity.PurchaseAppllyOrder;
import org.java.service.PurchaseAppllyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/14 23:32
 * @Description:
 */
@Service
public class PurchaseAppllyOrderServiceImpl implements PurchaseAppllyOrderService {
    @Autowired
    private PurchaseAppllyOrderMapper Mapper;

    @Override
    public List<PurchaseAppllyOrder> findPurchaseAppllyOrder(int page, int rows, Integer purchaseAppllyUserName) {

//        计算开始下标
        int start = (page - 1) * rows;

        return Mapper.findPurchaseAppllyOrder(start, rows, purchaseAppllyUserName);
    }
    @Override
    public int getCount(Integer purchaseAppllyUserName) {
        return Mapper.getCount(purchaseAppllyUserName);
    }

    @Transactional
    @Override
    public void add(PurchaseAppllyOrder p) {
        Mapper.insert(p);
    }

    @Transactional
    @Override
    public void update(PurchaseAppllyOrder p) {
        Mapper.updateByPrimaryKey(p);
    }

    @Transactional
    @Override
    public void del(String purchaseAppllyOrderId) {
        Mapper.deleteByPrimaryKey(purchaseAppllyOrderId);
    }

}