package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.OutEquipGoods;

import java.util.List;
@Mapper
public interface OutEquipGoodsMapper {
    int deleteByPrimaryKey(String outEquipGoodsId);

    int insert(OutEquipGoods record);

    int insertSelective(OutEquipGoods record);

    OutEquipGoods selectByPrimaryKey(String outEquipGoodsId);

    int updateByPrimaryKeySelective(OutEquipGoods record);

    int updateByPrimaryKey(OutEquipGoods record);

    List<OutEquipGoods> findOutEquipGoods(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchOutEquipGoodsId);

    Integer findOutEquipGoodsCount(@Param("id") String searchOutEquipGoodsId);
}