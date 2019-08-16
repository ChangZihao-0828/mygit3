package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.MatterReject;

import java.util.List;
@Mapper
public interface MatterRejectMapper {
    int deleteByPrimaryKey(String matterRejectId);

    int insert(MatterReject record);

    int insertSelective(MatterReject record);

    MatterReject selectByPrimaryKey(String matterRejectId);

    int updateByPrimaryKeySelective(MatterReject record);

    int updateByPrimaryKey(MatterReject record);

    List<MatterReject> findMatterReject(@Param("start") Integer start, @Param("rows") Integer rows, @Param("id") String searchMatterRejectId);

    Integer findMatterRejectCount(@Param("id") String searchMatterRejectId);
}