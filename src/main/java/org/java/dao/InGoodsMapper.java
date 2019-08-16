package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.ArriveNoticeOrder;
import org.java.entity.InGoods;

import java.util.List;

@Mapper
public interface InGoodsMapper {
    int deleteByPrimaryKey(String inGoodsId);

    int insert(InGoods record);

    int insertSelective(InGoods record);

    InGoods selectByPrimaryKey(String inGoodsId);

    int updateByPrimaryKeySelective(InGoods record);

    int updateByPrimaryKey(InGoods record);

    public List<InGoods> findInGoods(@Param("start") int start, @Param("rows") int rows, @Param("inGoodsId") String inGoodsId);

    public int getInGoodsCount(@Param("inGoodsId") String inGoodsId);
}