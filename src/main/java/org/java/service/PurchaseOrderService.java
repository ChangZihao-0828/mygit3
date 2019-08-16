package org.java.service;

import org.java.entity.PurchaseOrder;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 00:14
 * @Description:
 */
public interface PurchaseOrderService {
    public List<PurchaseOrder> findPurchaseOrder(int page, int rows, String purchaseOrderId);

    public int getPurchaseOrderCount(String purchaseOrderId);
}
