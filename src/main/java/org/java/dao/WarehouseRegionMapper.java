package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.WarehouseRegion;

import java.util.List;

@Mapper
public interface WarehouseRegionMapper {
    int deleteByPrimaryKey(String warehouseRegionId);

    int insert(WarehouseRegion record);

    int insertSelective(WarehouseRegion record);

    WarehouseRegion selectByPrimaryKey(String warehouseRegionId);

    int updateByPrimaryKeySelective(WarehouseRegion record);

    int updateByPrimaryKey(WarehouseRegion record);

    List<WarehouseRegion> findWarehouseRegion(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchWarehouseRegionId);

    Integer findWarehouseRegionCount(@Param("id") String searchWarehouseRegionId);

    List<WarehouseRegion> findByWarehouseName(@Param("warehouseName") String warehouseName);
}