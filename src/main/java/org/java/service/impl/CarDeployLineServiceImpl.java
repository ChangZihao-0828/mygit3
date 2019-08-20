package org.java.service.impl;

import org.java.dao.CarDeployLineMapper;
import org.java.entity.CarDeployLine;
import org.java.service.CarDeployLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title: Talk is cheap,show me the code.
 * @Author:
 * @Date: 2019/8/18 00:01
 * @Description: org.java.service.impl
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
@Service
public class CarDeployLineServiceImpl implements CarDeployLineService {

    @Autowired
    private CarDeployLineMapper mapper;
    @Override
    public List<CarDeployLine> findCarDeployLine(int page, int rows, String carDeployLineId) {
        //计算开始下标
        int start = (page-1)*rows;

        return mapper.findCarDeployLine(start,rows,carDeployLineId);
    }

    @Override
    public int getCarDeployLineCount(String carDeployLineId) {
        return mapper.getCarDeployLineCount(carDeployLineId);
    }

    @Transactional
    @Override
    public void add(CarDeployLine c) {

        mapper.insert(c);
    }

    @Transactional
    @Override
    public void update(CarDeployLine c) {
        mapper.updateByPrimaryKey(c);
    }

    @Override
    public void del(String carDeployLineId) {
        mapper.deleteByPrimaryKey(carDeployLineId);
    }

    @Transactional
    @Override
    public void UpdateCarFromSite(CarDeployLine c) {
        mapper.updateCarFromSite(c);
    }

    @Transactional
    @Override
    public void UpdateCarFromSiteIn(CarDeployLine c) {
        mapper.updateCarFromSiteIn(c);
    }

}
