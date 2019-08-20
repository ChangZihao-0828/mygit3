package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.TakeGoods;
import org.java.entity.WarehouseCheck;

import java.util.List;

@Mapper
public interface TakeGoodsMapper {
    int deleteByPrimaryKey(String takeGoodsId);

    int insert(TakeGoods record);

    int insertSelective(TakeGoods record);

    TakeGoods selectByPrimaryKey(String takeGoodsId);

    int updateByPrimaryKeySelective(TakeGoods record);

    int updateByPrimaryKey(TakeGoods record);

    List<TakeGoods> findTakeGoods(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchTakeGoodsId);

    Integer findTakeGoodsCount(@Param("id") String searchTakeGoodsId);
}