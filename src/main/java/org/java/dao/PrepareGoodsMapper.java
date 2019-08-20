package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.PrepareGoods;

import java.util.List;
@Mapper
public interface PrepareGoodsMapper {
    int deleteByPrimaryKey(String prepareGoodsId);

    int insert(PrepareGoods record);

    int insertSelective(PrepareGoods record);

    PrepareGoods selectByPrimaryKey(String prepareGoodsId);

    int updateByPrimaryKeySelective(PrepareGoods record);

    int updateByPrimaryKey(PrepareGoods record);

    public List<PrepareGoods> getList(@Param("start") int start, @Param("rows") int rows);

    public int getCount();

    List<PrepareGoods> findPrepareGoods(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchPrepareGoodsId);

    Integer findPrepareGoodsCount(@Param("id") String searchPrepareGoodsId);


}