package org.java.service;

import org.java.entity.*;

import java.util.List;

/**
 * @Author：邱泽英
 * @Date：2019/8/15 19:32
 * @Description：文件
 */
public interface BusinessService {

    //仓库管理-------------------------------------------------------------------------
    public List<Warehouse> findWarehouse(Integer page, Integer rows, String searchWarehouseId);

    public Integer findWarehouseCount(String searchWarehouseId);

    public void addWarehouse(Warehouse warehouse);

    public void delWarehouse(String warehouseId);

    public void updateWarehouse(Warehouse warehouse);

    //区域管理-------------------------------------------------------------------------
    public List<WarehouseRegion> findWarehouseRegion(Integer page, Integer rows, String searchWarehouseRegionId);

    public Integer findWarehouseRegionCount(String searchWarehouseRegionId);

    public void addWarehouseRegion(WarehouseRegion warehouseRegion);

    public void delWarehouseRegion(String searchWarehouseRegionId);

    public void updateWarehouseRegion(WarehouseRegion warehouseRegion);

    //仓位管理-------------------------------------------------------------------------
    public List<WarehousePosition> findWarehousePosition(Integer page, Integer rows, String searchWarehousePositionId);

    public Integer findWarehousePositionCount(String searchWarehousePositionId);

    public void addWarehousePosition(WarehousePosition warehousePosition);

    public void delWarehousePosition(String searchWarehousePositionId);

    public void updateWarehousePosition(WarehousePosition warehousePosition);

    //车辆管理-------------------------------------------------------------------------
    public List<Car> findCar(Integer page, Integer rows, Integer searchCarId);

    public Integer findCarCount(Integer searchCarId);

    public void addCar(Car car);

    public void delCar(Integer searchCarId);

    public void updateCar(Car car);

    //订单接收-------------------------------------------------------------------------
    public List<PurchaseOrder> findPurchaseOrder2(Integer page, Integer rows, String searchPurchaseOrderId);

    public Integer findPurchaseOrderCount2(String searchPurchaseOrderId);

    public void addPurchaseOrder(PurchaseOrder purchaseOrder);

    public void delPurchaseOrder(String searchPurchaseOrderId);

    public void updatePurchaseOrder(PurchaseOrder purchaseOrder);

    //备货-------------------------------------------------------------------------
    public List<PrepareGoods> findPrepareGoods(Integer page, Integer rows, String searchPrepareGoodsId);

    public Integer findPrepareGoodsCount(String searchPrepareGoodsId);

    public void addPrepareGoods(PrepareGoods prepareGoods);

    public void delPrepareGoods(String searchPrepareGoodsId);

    public void updatePrepareGoods(PrepareGoods prepareGoods);



}