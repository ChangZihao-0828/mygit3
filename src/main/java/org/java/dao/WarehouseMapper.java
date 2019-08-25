package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Warehouse;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    int deleteByPrimaryKey(String warehouseId);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(String warehouseId);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

    List<Warehouse> findWarehouse(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchWarehouseId);

    Integer findWarehouseCount(@Param("id") String searchWarehouseId);

    List<Warehouse> findAll();

}