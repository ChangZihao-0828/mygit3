package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.PrepareGoods;
import org.java.entity.PurchaseOrder;

import java.util.List;

@Mapper
public interface PurchaseOrderMapper {
    int deleteByPrimaryKey(String purchaseOrderId);

    int insert(PurchaseOrder record);

    int insertSelective(PurchaseOrder record);

    PurchaseOrder selectByPrimaryKey(String purchaseOrderId);

    int updateByPrimaryKeySelective(PurchaseOrder record);

    int updateByPrimaryKey(PurchaseOrder record);

    public List<PurchaseOrder> findPurchaseOrder(@Param("start") int start, @Param("rows") int rows, @Param("purchaseOrderId") String purchaseOrderId);

    public int getPurchaseOrderCount(@Param("purchaseOrderId") String purchaseOrderId);

    List<PurchaseOrder> findPurchaseOrder2(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchPurchaseOrderId);

    Integer findPurchaseOrderCount2(@Param("id") String searchPurchaseOrderId);


}