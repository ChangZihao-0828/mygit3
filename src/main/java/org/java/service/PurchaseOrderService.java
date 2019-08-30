package org.java.service;

import org.java.entity.PurchaseOrder;

import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 00:14
 * @Description:
 */
public interface PurchaseOrderService {
    public List<PurchaseOrder> findPurchaseOrder(int page, int rows, String purchaseUserId);
    public void add(PurchaseOrder e);
    public int getPurchaseOrderCount(String purchaseOrderId);
    public void updatePurchaseOrder(PurchaseOrder e);
    public int delPurchaseOrder(String purchaseOrderId);
    public void submitPurchaseOrder(String id,String price);
    public List<PurchaseOrder> findPurchaseOrderAll(int page, int rows, String purchaseUserId);
    public int findCount(String purchaseUserId);
    public List<PurchaseOrder>findGroupPurchaseOrder();
    public int findGroupOrderCount();
}
