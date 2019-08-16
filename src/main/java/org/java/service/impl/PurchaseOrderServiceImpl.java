package org.java.service.impl;

import org.java.dao.PurchaseOrderMapper;
import org.java.entity.PurchaseOrder;
import org.java.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 00:17
 * @Description:
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderMapper Mapper;

    @Override
    public List<PurchaseOrder> findPurchaseOrder(int page, int rows, String purchaseOrderId) {
        //        计算开始下标
        int start = (page - 1) * rows;

        return Mapper.findPurchaseOrder(start, rows, purchaseOrderId);
    }

    @Override
    public int getPurchaseOrderCount(String purchaseOrderId) {
        return Mapper.getPurchaseOrderCount(purchaseOrderId);
    }
}
