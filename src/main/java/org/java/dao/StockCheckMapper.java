package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.StockCheck;

import java.util.List;

@Mapper
public interface StockCheckMapper {
    int deleteByPrimaryKey(String stockCheckId);

    int insert(StockCheck record);

    int insertSelective(StockCheck record);

    StockCheck selectByPrimaryKey(String stockCheckId);

    int updateByPrimaryKeySelective(StockCheck record);

    int updateByPrimaryKey(StockCheck record);

    List<StockCheck> findStockCheck(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchStockCheckId);

    Integer findStockCheckCount(@Param("id") String searchStockCheckId);
}