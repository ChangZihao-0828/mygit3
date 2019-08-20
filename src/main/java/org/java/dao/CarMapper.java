package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Car;
import org.java.entity.Warehouse;

import java.util.List;

@Mapper
public interface CarMapper {
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> findCar(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") Integer searchCarId);

    Integer findCarCount(@Param("id") Integer searchCarId);

    List<Car> findCarManager(int start, int rows, Integer carId);

    int getCarManagerCount(Integer carId);

}