package org.java.service;

import org.java.entity.CarDeployLine;

import java.util.List;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author:
 * @Date: 2019/8/17 23:57
 * @Description: org.java.service
 * _ooOoo_               .--,       .--,
 * o888888o             ( (  \.---./  ) )
 * 88" . "88             '.__/o   o\__.'
 * (| -_- |)                {=  ^  =}
 * O\ = /O                   >  -  <
 * _/`---'\___              /       \
 * _/`---'\_____           //       \\
 * .' \\| |// `.          //|   .   |\\
 * / \\||| : |||// \      "'\       /'"_.-~^`'-.
 * / _||||| -:- |||||- \     \  _  /--'         `
 * | | \\\ - /// | |       ___)( )(___
 * | \_| ''\---/'' | |    (((__) (__)))
 */
public interface CarDeployLineService {
    public List<CarDeployLine> findCarDeployLine(int page, int rows, String carDeployLineId);

    public int getCarDeployLineCount(String carDeployLineId);

    public void add(CarDeployLine c);

    public void update(CarDeployLine c);

    public void del(String carDeployLineId);

    public void UpdateCarFromSite(CarDeployLine c);

    public void UpdateCarFromSiteIn(CarDeployLine c);
}
