package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.ArriveNoticeOrder;

import java.util.List;
@Mapper
public interface ArriveNoticeOrderMapper {
    int deleteByPrimaryKey(String arriveNoticeOrderId);

    int insert(ArriveNoticeOrder record);

    int insertSelective(ArriveNoticeOrder record);

    ArriveNoticeOrder selectByPrimaryKey(String arriveNoticeOrderId);

    int updateByPrimaryKeySelective(ArriveNoticeOrder record);

    int updateByPrimaryKey(ArriveNoticeOrder record);

    public List<ArriveNoticeOrder> findArriveNoticeOrder(@Param("start") int start, @Param("rows") int rows, @Param("arriveNoticeOrderId") String arriveNoticeOrderId);

    public int getArriveNoticeOrderCount(@Param("arriveNoticeOrderId") String arriveNoticeOrderId);
}