package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.CustomerOrder;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/17 15:30
 * @Description: Frighting!!!
 */

@Mapper
public interface CustomerOrderMapper1 {

    int deleteByPrimaryKey(String customerOrderId);

    int insert(CustomerOrder record);

    int insertSelective(CustomerOrder record);

    CustomerOrder selectByPrimaryKey(String customerOrderId);

    int updateByPrimaryKeySelective(CustomerOrder record);

    int updateByPrimaryKey(CustomerOrder record);

    public List<CustomerOrder> findCustomerOrder(@Param("start") int start, @Param("rows") int rows, @Param("customerOrderId") String customerOrderId);

    public int getCustomerOrderCount(@Param("customerOrderId") String customerOrderId);

    public List<CustomerOrder> getList(@Param("start") int start, @Param("rows") int rows);

    public int getCount();
}
