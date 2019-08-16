package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.ArriveNoticeOrder;
import org.java.entity.CustomerOrder;

import java.util.List;

@Mapper
public interface CustomerOrderMapper {
    int deleteByPrimaryKey(String customerOrderId);

    int insert(CustomerOrder record);

    int insertSelective(CustomerOrder record);

    CustomerOrder selectByPrimaryKey(String customerOrderId);

    int updateByPrimaryKeySelective(CustomerOrder record);

    int updateByPrimaryKey(CustomerOrder record);
    public List<CustomerOrder> findCustomerOrder(@Param("start") int start, @Param("rows") int rows, @Param("customerOrderId") String customerOrderId);

    public int getCustomerOrderCount(@Param("customerOrderId") String customerOrderId);
}