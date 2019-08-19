package org.java.service.impl;

import org.java.dao.OutEquipGoodsMapper;
import org.java.entity.OutEquipGoods;
import org.java.service.OutEquipGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 10:47
 * @Description: Frighting!!!
 */

@Service
public class OutEquipGoodsServiceImpl implements OutEquipGoodsService {


    @Autowired
    private OutEquipGoodsMapper outEquipGoodsMapper;

    @Transactional
    @Override
    public void addOutEquipGoods(OutEquipGoods outEquipGoods) {


        System.out.println("-----");
        outEquipGoodsMapper.insertSelective(outEquipGoods);
        System.out.println("-----------------");
    }

    @Override
    public List<OutEquipGoods> findOutEquipGoods(Integer page, Integer rows, String searchOutEquipGoodsId) {
        int start = (page-1)*rows;

        return outEquipGoodsMapper.findOutEquipGoods(start,rows,searchOutEquipGoodsId);
    }

    @Override
    public Integer findOutEquipGoodsCount(String searchOutEquipGoodsId) {

        return outEquipGoodsMapper.findOutEquipGoodsCount(searchOutEquipGoodsId);
    }
}
