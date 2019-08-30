package org.java.dao;

import org.java.entity.PutGoods;

public interface PutGoodsMapper {
    int deleteByPrimaryKey(String putGoodsId);

    int insert(PutGoods record);

    int insertSelective(PutGoods record);

    PutGoods selectByPrimaryKey(String putGoodsId);

    int updateByPrimaryKeySelective(PutGoods record);

    int updateByPrimaryKey(PutGoods record);
}