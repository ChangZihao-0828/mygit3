package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.ArriveNoticeOrder;
import org.java.entity.Car;

import java.util.List;

@Mapper
public interface CarMapper {
    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    public List<Car> findCarManager(@Param("start") int start, @Param("rows") int rows, @Param("carId") Integer carId);

    public int getCarManagerCount(@Param("carId") Integer carId);

}