package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.DeliverGoods;

import java.util.List;
@Mapper
public interface DeliverGoodsMapper {
    int deleteByPrimaryKey(String deliverGoodsId);

    int insert(DeliverGoods record);

    int insertSelective(DeliverGoods record);

    DeliverGoods selectByPrimaryKey(String deliverGoodsId);

    int updateByPrimaryKeySelective(DeliverGoods record);

    int updateByPrimaryKey(DeliverGoods record);

    public List<DeliverGoods> findDeliverGoods(@Param("start") int start, @Param("rows") int rows, @Param("deliverGoodsId") String deliverGoodsId);

    public int getDeliverGoodsCount(@Param("deliverGoodsId") String deliverGoodsId);
}