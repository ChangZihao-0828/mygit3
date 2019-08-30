package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Motorcade;

import java.util.List;

@Mapper
public interface MotorcadeMapper {
    int deleteByPrimaryKey(Integer motorcadeId);

    int insert(Motorcade record);

    int insertSelective(Motorcade record);

    Motorcade selectByPrimaryKey(Integer motorcadeId);

    int updateByPrimaryKeySelective(Motorcade record);

    int updateByPrimaryKey(Motorcade record);

    List<Motorcade> findAll();
}