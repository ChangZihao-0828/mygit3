package org.java.service.impl;

import org.java.dao.ArriveNoticeOrderMapper;
import org.java.entity.ArriveNoticeOrder;
import org.java.service.ArriveNoticeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 10:10
 * @Description:
 */
@Service
public class ArriveNoticeOrderServiceImpl implements ArriveNoticeOrderService {
    @Autowired
    private ArriveNoticeOrderMapper mapper;
    @Override
    public List<ArriveNoticeOrder> findArriveNoticeOrder(int page, int rows, String arriveNoticeOrderId) {
        //        计算开始下标
        int start = (page - 1) * rows;

        return mapper.findArriveNoticeOrder(start,rows,arriveNoticeOrderId);

    }
    @Transactional
    @Override
    public int getArriveNoticeOrderCount(String arriveNoticeOrderId) {
       return mapper.getArriveNoticeOrderCount(arriveNoticeOrderId);
    }
    @Transactional
    @Override
    public void add(ArriveNoticeOrder e) {
        mapper.insert(e);
    }
    @Transactional
    @Override
    public int delArriveNoticeOrder(String arriveNoticeOrderId) {
        return mapper.deleteByPrimaryKey(arriveNoticeOrderId);
    }
    @Transactional
    @Override
    public void updateArriveNoticeOrder(ArriveNoticeOrder e) {
        mapper.updateByPrimaryKeySelective(e);
    }
}
