package org.java.service;

import org.java.entity.Car;
import org.java.entity.CarDeployLine;

import java.util.List;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author:
 * @Date: 2019/8/18 08:43
 * @Description: org.java.service
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
public interface CarManagerService {
    public List<Car> findCarManager(int page, int rows, Integer carId);

    public int getCarManagerCount(Integer carId);

    public void add(Car c);

    public void update(Car c);

    public void del(Integer carId);
}
