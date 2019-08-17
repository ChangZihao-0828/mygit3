package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.WarehouseCheck;

import java.util.List;
@Mapper
public interface WarehouseCheckMapper {
    int deleteByPrimaryKey(String warehouseCheckId);

    int insert(WarehouseCheck record);

    int insertSelective(WarehouseCheck record);

    WarehouseCheck selectByPrimaryKey(String warehouseCheckId);

    int updateByPrimaryKeySelective(WarehouseCheck record);

    int updateByPrimaryKey(WarehouseCheck record);

    List<WarehouseCheck> findWarehouseCheck(@Param("start") Integer start,@Param("rows") Integer rows,@Param("id") String searchWarehouseCheckId);

    Integer findWarehouseCheckCount(@Param("id") String searchWarehouseCheckId);
}