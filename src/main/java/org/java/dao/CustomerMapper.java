package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Customer;
import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    int deleteByPrimaryKey(String customer_id);
    int insert(Customer record);
    int insertSelective(Customer record);
    Customer selectByPrimaryKey(String customer_id);
    int updateByPrimaryKeySelective(Customer record);
    int updateByPrimaryKey(Customer record);
    int getCount(@Param("id") String searchcustomerid);
    List<Customer> getList(@Param("start") int start, @Param("rows") int rows,@Param("id") String searchcustomerid);

}
