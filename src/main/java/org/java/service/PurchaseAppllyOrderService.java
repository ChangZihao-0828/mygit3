package org.java.service;

import org.java.entity.PurchaseAppllyOrder;

import java.util.List;
import java.util.Map;

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

    public void submitPurchaseApplyOrder(String id,String defkey);

    public List<PurchaseAppllyOrder> findPurchaseAppllyOrderAll(int page, int rows, Integer purchaseAppllyUserName);

    public int findCount(Integer purchaseAppllyUserName);

    public List<Map> findGroupPurchaseApplyOrder();

    public int findGroupPurchaseApplyOrderCount();

}
