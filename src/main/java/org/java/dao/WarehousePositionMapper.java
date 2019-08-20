package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.WarehousePosition;
import org.java.entity.WarehouseRegion;

import java.util.List;

@Mapper
public interface WarehousePositionMapper {
    int deleteByPrimaryKey(String warehousePositionId);

    int insert(WarehousePosition record);

    int insertSelective(WarehousePosition record);

    WarehousePosition selectByPrimaryKey(String warehousePositionId);

    int updateByPrimaryKeySelective(WarehousePosition record);

    int updateByPrimaryKey(WarehousePosition record);

    List<WarehousePosition> findWarehousePosition(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchWarehousePositionId);

    Integer findWarehousePositionCount(@Param("id") String searchWarehousePositionId);
}