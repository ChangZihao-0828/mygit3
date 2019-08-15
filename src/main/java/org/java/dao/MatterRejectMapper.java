package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
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

    List<MatterReject> findMatterReject();

    Integer findMatterRejectCount();
}