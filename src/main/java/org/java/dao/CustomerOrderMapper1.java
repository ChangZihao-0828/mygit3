package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.CustomerOrder;

import java.util.List;

@Mapper
public interface CustomerOrderMapper1 {
    int deleteByPrimaryKey(String customerOrderId);

    int insert(CustomerOrder record);

    int insertSelective(CustomerOrder record);

    CustomerOrder selectByPrimaryKey(String customerOrderId);

    int updateByPrimaryKeySelective(CustomerOrder record);

    int updateByPrimaryKey(CustomerOrder record);

    public List<CustomerOrder> getList(@Param("start") int start, @Param("rows") int rows);

    public int getCount();
}