package org.java.service.impl;

import org.java.dao.TakeGoodsMapper;
import org.java.entity.TakeGoods;
import org.java.service.TakeGoodsService;
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
public class TakeGoodsServiceImpl implements TakeGoodsService {

    @Autowired
    private TakeGoodsMapper takeGoodsMapper;

    @Transactional
    @Override
    public void addTakeGoods(TakeGoods takeGoods) {
        takeGoodsMapper.insert(takeGoods);
    }

    @Override
    public List<TakeGoods> findTakeGoods(Integer page, Integer rows, String searchTakeGoodsId) {
        int start = (page-1)*rows;
        return findTakeGoods(start,rows,searchTakeGoodsId);
    }

    @Override
    public Integer findTakeGoodsCount(String searchTakeGoodsId) {
        return takeGoodsMapper.findTakeGoodsCount(searchTakeGoodsId);
    }
}
