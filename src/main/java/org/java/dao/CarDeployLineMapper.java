package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.ArriveNoticeOrder;
import org.java.entity.CarDeployLine;

import java.util.List;

@Mapper
public interface CarDeployLineMapper {
    int deleteByPrimaryKey(String carDeployLineId);

    int insert(CarDeployLine record);

    int insertSelective(CarDeployLine record);

    CarDeployLine selectByPrimaryKey(String carDeployLineId);

    int updateByPrimaryKeySelective(CarDeployLine record);

    int updateByPrimaryKey(CarDeployLine record);

    public List<CarDeployLine> findCarDeployLine(@Param("start") int start, @Param("rows") int rows, @Param("carDeployLineId") String carDeployLineId);

    public int getCarDeployLineCount(@Param("carDeployLineId") String carDeployLineId);

    int updateCarFromSite(CarDeployLine record);

    int updateCarFromSiteIn(CarDeployLine record);
}