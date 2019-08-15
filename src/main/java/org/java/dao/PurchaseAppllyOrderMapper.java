package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.PurchaseAppllyOrder;

import java.util.List;

@Mapper
public interface PurchaseAppllyOrderMapper {
    int deleteByPrimaryKey(String purchaseAppllyOrderId);

    int insert(PurchaseAppllyOrder record);

    int insertSelective(PurchaseAppllyOrder record);

    PurchaseAppllyOrder selectByPrimaryKey(String purchaseAppllyOrderId);

    int updateByPrimaryKeySelective(PurchaseAppllyOrder record);

    int updateByPrimaryKey(PurchaseAppllyOrder record);

    int findPurchaseAppllyOrder(String purchaseAppllyOrderId);

    public List<PurchaseAppllyOrder> findPurchaseAppllyOrder(@Param("start") int start, @Param("rows") int rows, @Param("purchaseAppllyUserName") Integer purchaseAppllyUserName);

    public int getCount(@Param("purchaseAppllyUserName") Integer purchaseAppllyUserName);
}