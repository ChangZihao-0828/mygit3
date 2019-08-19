package org.java.service.impl;

import org.java.dao.DeliverGoodsMapper;
import org.java.entity.DeliverGoods;
import org.java.service.DeliverGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 12:46
 * @Description:
 */
@Service
public class DeliverGoodsServiceImpl implements DeliverGoodsService {
    @Autowired
    private DeliverGoodsMapper mapper;
    @Override
    public List<DeliverGoods> findDeliverGoods(int page, int rows, String deliverGoodsId) {
        int start = (page - 1) * rows;

        return mapper.findDeliverGoods(start,rows,deliverGoodsId);
    }

    @Override
    public int getDeliverGoodsCount(String deliverGoodsId) {
        return mapper.getDeliverGoodsCount(deliverGoodsId);
    }

    @Transactional
    @Override
    public void add(DeliverGoods d) {
          mapper.insert(d);
    }

    @Transactional
    @Override
    public void update(DeliverGoods d) {
        mapper.updateByPrimaryKey(d);
    }

    @Transactional
    @Override
    public void del(String deliverGoodsId) {
        mapper.deleteByPrimaryKey(deliverGoodsId);
    }
}
