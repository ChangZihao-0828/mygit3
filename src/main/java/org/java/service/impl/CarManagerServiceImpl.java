package org.java.service.impl;

import org.java.dao.CarMapper;
import org.java.entity.Car;
import org.java.entity.CarDispatch;
import org.java.service.CarManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author:
 * @Date: 2019/8/18 08:46
 * @Description: org.java.service.impl
 * _ooOoo_                  .--,       .--,
 * o888888o                ( (  \.---./  ) )
 * 88" . "88                '.__/o   o\__.'
 * (| -_- |)                   {=  ^  =}
 * O\ = /O                      >  -  <
 * _/`---'\___                 /       \
 * _/`---'\_____              //       \\
 * .' \\| |// `.             //|   .   |\\
 * / \\||| : |||// \         "'\       /'"_.-~^`'-.
 * / _||||| -:- |||||- \        \  _  /--'         `
 * | | \\\ - /// | |          ___)( )(___
 * | \_| ''\---/'' | |       (((__) (__)))
 */
@Service
public class CarManagerServiceImpl implements CarManagerService {
    @Autowired
    private CarMapper mapper;
    @Override
    public List<Car> findCarManager(int page, int rows, Integer carId) {
        int start = (page-1)*rows;

        return mapper.findCarManager(start,rows,carId);
    }

    @Override
    public int getCarManagerCount(Integer carId) {
        return mapper.getCarManagerCount(carId);
    }

    @Transactional
    @Override
    public void add(Car c) {

        mapper.insert(c);
    }

    @Transactional
    @Override
    public void update(Car c) {
        mapper.updateByPrimaryKey(c);
    }

    @Override
    public void del(Integer carId) {
        mapper.deleteByPrimaryKey(carId);
    }

    }

