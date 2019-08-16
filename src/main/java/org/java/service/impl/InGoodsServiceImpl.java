package org.java.service.impl;

import org.java.dao.InGoodsMapper;
import org.java.entity.InGoods;
import org.java.service.InGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 11:21
 * @Description:
 */
@Service
public class InGoodsServiceImpl implements InGoodsService {
    @Autowired
    private InGoodsMapper mapper;
    @Override
    public List<InGoods> findInGoods(int page, int rows, String inGoodsId) {
        //        计算开始下标
        int start = (page - 1) * rows;

        return mapper.findInGoods(start,rows,inGoodsId);
    }

    @Override
    public int getInGoodsCount(String inGoodsId) {
        return mapper.getInGoodsCount(inGoodsId);
    }
}
