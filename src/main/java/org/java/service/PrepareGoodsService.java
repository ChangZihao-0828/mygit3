package org.java.service;

import org.java.entity.PrepareGoods;

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
public interface PrepareGoodsService {
    public List<PrepareGoods> getList(int page, int rows,String seachsupplierId);
    public int getCount();
    public void add(PrepareGoods e);
    public int delPrepareGoods1(String prepareGoodsId);
    public void updateSupplier(PrepareGoods e);
}
