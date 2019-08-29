package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    CustomerOrder selectByProcessinstanceId(@Param("processinstanceId") String processinstanceId,@Param("state") String state);

    public List<CustomerOrder> findCustomerOrder(@Param("start") int start, @Param("rows") int rows, @Param("customerOrderId") String customerOrderId);

    public int getCustomerOrderCount(@Param("customerOrderId") String customerOrderId);

    public List<CustomerOrder> getList(int start,int rows);

    public int getCount();

}