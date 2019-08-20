package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Supplier;

import java.util.List;

@Mapper
public interface SupplierMapper {
    int deleteByPrimaryKey(String supplierId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(String supplierId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
     List<Supplier> getList(@Param("start") int start, @Param("rows") int rows,@Param("id") String searchsupplierId);
    Integer findsupplierCount(@Param("id") String searchsupplierId);
     int getCount();

}