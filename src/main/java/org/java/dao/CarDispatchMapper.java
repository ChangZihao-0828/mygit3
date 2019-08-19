package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.ArriveNoticeOrder;
import org.java.entity.CarDispatch;

import java.util.List;

@Mapper
public interface CarDispatchMapper {
    int deleteByPrimaryKey(String carDispatchId);

    int insert(CarDispatch record);

    int insertSelective(CarDispatch record);

    CarDispatch selectByPrimaryKey(String carDispatchId);

    int updateByPrimaryKeySelective(CarDispatch record);

    int updateByPrimaryKey(CarDispatch record);

    public List<CarDispatch> findCarDispatch(@Param("start") int start, @Param("rows") int rows, @Param("carDispatchId") String carDispatchId);

    public int getCarDispatchCount(@Param("carDispatchId") String carDispatchId);

}