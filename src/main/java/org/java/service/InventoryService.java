package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.entity.*;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/13 11:10
 * @Description: Frighting!!!
 */


public interface InventoryService {

    public List<WarehouseCheck> findWarehouseCheck(Integer page,Integer rows,String searchWarehouseCheckId);

    public Integer findWarehouseCheckCount(String searchWarehouseCheckId);

    public List<MatterCheck> findMatterCheck(Integer page,Integer rows,String searchMatterCheckId);

    public Integer findMatterCheckCount(String searchMatterCheckId);

    public List<MatterReject> findMatterReject(Integer page,Integer rows,String searchMatterRejectId);

    public Integer findMatterRejectCount(String searchMatterRejectId);

    public List<StockCheck> findStockCheck(Integer page,Integer rows,String searchStockCheckId);

    public Integer findStockCheckCount(String searchStockCheckId);

    public void delWarehouseCheck(String warehouseCheckId);

    public void delMatterCheck(String matterCheckId);

    public void delStockCheck(String stockCheckId);

    public void delMatterReject(String matterCheckId);

    public void addWarehouseCheck(WarehouseCheck warehouseCheck);

    public void addMatterCheck(MatterCheck matterCheck);

    public void addStockCheck(StockCheck stockCheck);

    public void addMatterReject(MatterReject matterReject);

    public void updateWarehouseCheck(WarehouseCheck warehouseCheck);

    public void updateMatterCheck(MatterCheck matterCheck);

    public void updateStockCheck(StockCheck stockCheck);

    public void updateMatterReject(MatterReject matterReject);


}
