package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<CarDeployLine> findCarDeployLine(@Param("start") Integer start, @Param("rows") Integer rows, @Param("carDeployLineId") String carDeployLineId);

    Integer getCarDeployLineCount(@Param("carDeployLineId") String carDeployLineId);

    public void updateCarFromSite(CarDeployLine c);

    public void updateCarFromSiteIn(CarDeployLine c);
}