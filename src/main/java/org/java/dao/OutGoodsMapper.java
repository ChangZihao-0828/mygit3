package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.OutGoods;

import java.util.List;
@Mapper
public interface OutGoodsMapper {
    int deleteByPrimaryKey(String outGoodsId);

    int insert(OutGoods record);

    int insertSelective(OutGoods record);

    OutGoods selectByPrimaryKey(String outGoodsId);

    int updateByPrimaryKeySelective(OutGoods record);

    int updateByPrimaryKey(OutGoods record);

    List<OutGoods> findOutGoods(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchDeliveryReceivingId, @Param("outGoodsStatus") String outGoodsStatus);

    Integer findOutGoodsCount(@Param("id") String searchDeliveryReceivingId,@Param("outGoodsStatus") String outGoodsStatus);

    OutGoods findOutGoodsByProcessinstanceId(@Param("outGoodsStatus") String outGoodsStatus,@Param("processinstanceId") String processinstanceId);
}