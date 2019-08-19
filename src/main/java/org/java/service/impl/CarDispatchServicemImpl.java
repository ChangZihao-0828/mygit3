package org.java.service.impl;

import org.java.dao.CarDispatchMapper;
import org.java.entity.CarDispatch;
import org.java.service.CarDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/17 20:38
 * @Description:
 */
@Service
public class CarDispatchServicemImpl implements CarDispatchService {

    @Autowired
    private CarDispatchMapper mapper;
    @Override
    public List<CarDispatch> findCarDispatch(int page, int rows, String carDispatchId) {
        //计算开始下标
        int start = (page-1)*rows;

        return mapper.findCarDispatch(start,rows,carDispatchId);
    }

    @Override
    public int getCarDispatchCount(String carDispatchId) {
        return mapper.getCarDispatchCount(carDispatchId);
    }

    @Transactional
    @Override
    public void add(CarDispatch c) {

        mapper.insert(c);
    }

    @Transactional
    @Override
    public void update(CarDispatch c) {
        mapper.updateByPrimaryKey(c);
    }

    @Override
    public void del(String carDispatchId) {
        mapper.deleteByPrimaryKey(carDispatchId);
    }
}
