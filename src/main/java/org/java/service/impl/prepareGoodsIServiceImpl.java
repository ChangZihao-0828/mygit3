package org.java.service.impl;

import org.java.dao.PrepareGoodsMapper;
import org.java.entity.PrepareGoods;
import org.java.service.PrepareGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  * $methodName$
 * $params$
 *  * @Description 方法描述,必填  <br/>
 *  * @return $return$
 *  * @throw $throw$ 
 *  * @author 陈威
 *  * @createTime $date$ $time$
 *  * @Version V1.0.0
 *  
 */
@Service
public class prepareGoodsIServiceImpl implements PrepareGoodsService {


    @Autowired
    private PrepareGoodsMapper prepareGoodsMapper;

    @Override
    public List<PrepareGoods> getList(int page, int rows, String prepareGoodsId) {
        int start = (page-1)*rows;
        return prepareGoodsMapper.getList(0,4);
    }
    @Transactional
    @Override
    public int getCount() {
        return prepareGoodsMapper.getCount();
    }
    @Transactional
    @Override
    public void add(PrepareGoods e) {
    prepareGoodsMapper.insert(e);
    }
    @Transactional
    @Override
    public int delPrepareGoods1(String prepareGoodsId) {
        return prepareGoodsMapper.deleteByPrimaryKey(prepareGoodsId);
    }
    @Transactional
    @Override
    public void updateSupplier(PrepareGoods e) {
    prepareGoodsMapper.updateByPrimaryKeySelective(e);
    }
}
