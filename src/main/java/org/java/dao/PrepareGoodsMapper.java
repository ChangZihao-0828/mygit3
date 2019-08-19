package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.PrepareGoods;
import org.java.entity.Warehouse;

import java.util.List;

@Mapper
public interface PrepareGoodsMapper {
    int deleteByPrimaryKey(String prepareGoodsId);

    int insert(PrepareGoods record);

    int insertSelective(PrepareGoods record);

    PrepareGoods selectByPrimaryKey(String prepareGoodsId);

    int updateByPrimaryKeySelective(PrepareGoods record);

    int updateByPrimaryKey(PrepareGoods record);

    List<PrepareGoods> findPrepareGoods(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchPrepareGoodsId);

    Integer findPrepareGoodsCount(@Param("id") String searchPrepareGoodsId);

    List<PrepareGoods> findPrepareGoods2(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchPrepareGoodsId);

    Integer findPrepareGoodsCount2(@Param("id") String searchPrepareGoodsId);
}