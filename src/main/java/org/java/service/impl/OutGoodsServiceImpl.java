package org.java.service.impl;

import org.java.dao.OutGoodsMapper;
import org.java.entity.OutGoods;
import org.java.service.OutGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 09:29
 * @Description: Frighting!!!
 */

@Service
public class OutGoodsServiceImpl implements OutGoodsService {

    @Autowired
    private OutGoodsMapper outGoodsMapper;

    @Transactional
    @Override
    public void addDeliveryReceiving(OutGoods outGoods) {

        outGoodsMapper.insert(outGoods);
    }

    @Override
    public List<OutGoods> findOutGoods(Integer page, Integer rows, String searchDeliveryReceivingId,String outGoodsStatus) {

        int start = (page-1)*rows;

        System.out.println("-----------------"+outGoodsStatus);
        return outGoodsMapper.findOutGoods(start,rows,searchDeliveryReceivingId,outGoodsStatus);
    }

    @Override
    public Integer findOutGoodsCount(String searchDeliveryReceivingId,String outGoodsStatus) {

        return outGoodsMapper.findOutGoodsCount(searchDeliveryReceivingId,outGoodsStatus);
    }

    @Override
    public void updateOutGoodsStatus(OutGoods record) {

        outGoodsMapper.updateByPrimaryKeySelective(record);
    }
}
