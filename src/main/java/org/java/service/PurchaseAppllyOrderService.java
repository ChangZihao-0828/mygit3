package org.java.service;

import org.java.entity.PurchaseAppllyOrder;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/13 16:58
 * @Description:
 */

public interface PurchaseAppllyOrderService {

    public List<PurchaseAppllyOrder> findPurchaseAppllyOrder(int page, int rows, Integer purchaseAppllyUserName);

    public int getCount(Integer purchaseAppllyUserName);

    public void add(PurchaseAppllyOrder p);

    public void update(PurchaseAppllyOrder p);

    public void del(String purchaseAppllyOrderId);

    public void submitPurchaseApplyOrder(String id,String price);

    public List<PurchaseAppllyOrder> findPurchaseAppllyOrderAll(int page, int rows, Integer purchaseAppllyUserName);

    public int findCount(Integer purchaseAppllyUserName);

    public List<PurchaseAppllyOrder> findGroupPurchaseApplyOrder();

    public int findGroupPurchaseApplyOrderCount();

}
