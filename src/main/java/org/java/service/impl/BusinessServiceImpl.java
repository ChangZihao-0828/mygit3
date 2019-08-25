package org.java.service.impl;

import org.java.dao.*;
import org.java.entity.*;
import org.java.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：邱泽英
 * @Date：2019/8/16 11:19
 * @Description：文件
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private WarehouseRegionMapper warehouseRegionMapper;

    @Autowired
    private WarehousePositionMapper warehousePositionMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private PrepareGoodsMapper prepareGoodsMapper;

    @Autowired
    private WarehouserTypeMapper warehouserTypeMapper;

    //仓库管理-------------------------------------------------------------------------
    @Override
    public List<Warehouse> findWarehouse(Integer page, Integer rows, String searchWarehouseId) {

        int start = (page - 1) * rows;

        return warehouseMapper.findWarehouse(start, rows, searchWarehouseId);
    }

    @Override
    public Integer findWarehouseCount(String searchWarehouseId) {

        return warehouseMapper.findWarehouseCount(searchWarehouseId);
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {

        warehouseMapper.insert(warehouse);
    }

    @Override
    public void delWarehouse(String warehouseId) {

        warehouseMapper.deleteByPrimaryKey(warehouseId);
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {

        warehouseMapper.updateByPrimaryKey(warehouse);
    }

    //区域管理-------------------------------------------------------------------------
    @Override
    public List<WarehouseRegion> findWarehouseRegion(Integer page, Integer rows, String searchWarehouseRegionId) {

        int start = (page - 1) * rows;

        return warehouseRegionMapper.findWarehouseRegion(start, rows, searchWarehouseRegionId);
    }

    @Override
    public Integer findWarehouseRegionCount(String searchWarehouseRegionId) {
        return warehouseRegionMapper.findWarehouseRegionCount(searchWarehouseRegionId);
    }

    @Override
    public void addWarehouseRegion(WarehouseRegion warehouseRegion) {
        warehouseRegionMapper.insert(warehouseRegion);
    }

    @Override
    public void delWarehouseRegion(String searchWarehouseRegionId) {
        warehouseRegionMapper.deleteByPrimaryKey(searchWarehouseRegionId);
    }

    @Override
    public void updateWarehouseRegion(WarehouseRegion warehouseRegion) {
        warehouseRegionMapper.updateByPrimaryKey(warehouseRegion);
    }

    //仓位管理-------------------------------------------------------------------------
    @Override
    public List<WarehousePosition> findWarehousePosition(Integer page, Integer rows, String searchWarehousePositionId) {

        int start = (page - 1) * rows;

        return warehousePositionMapper.findWarehousePosition(start, rows, searchWarehousePositionId);
    }

    @Override
    public Integer findWarehousePositionCount(String searchWarehousePositionId) {
        return warehousePositionMapper.findWarehousePositionCount(searchWarehousePositionId);
    }

    @Override
    public void addWarehousePosition(WarehousePosition warehousePosition) {
        warehousePositionMapper.insert(warehousePosition);
    }

    @Override
    public void delWarehousePosition(String searchWarehousePositionId) {
        warehousePositionMapper.deleteByPrimaryKey(searchWarehousePositionId);
    }

    @Override
    public void updateWarehousePosition(WarehousePosition warehousePosition) {
        warehousePositionMapper.updateByPrimaryKey(warehousePosition);
    }

    //车辆管理-------------------------------------------------------------------------
    @Override
    public List<Car> findCar(Integer page, Integer rows, Integer searchCarId) {

        int start = (page - 1) * rows;

        return carMapper.findCar(start, rows, searchCarId);
    }

    @Override
    public Integer findCarCount(Integer searchCarId) {
        return carMapper.findCarCount(searchCarId);
    }

    @Override
    public void addCar(Car car) {
        carMapper.insert(car);
    }

    @Override
    public void delCar(Integer searchCarId) {
        carMapper.deleteByPrimaryKey(searchCarId);
    }

    @Override
    public void updateCar(Car car) {
        carMapper.updateByPrimaryKey(car);
    }

    //订单接收-------------------------------------------------------------------------
    @Override
    public List<PurchaseOrder> findPurchaseOrder2(Integer page, Integer rows, String searchPurchaseOrderId) {

        int start = (page - 1) * rows;

        return purchaseOrderMapper.findPurchaseOrder2(start, rows, searchPurchaseOrderId);
    }

    @Override
    public Integer findPurchaseOrderCount2(String searchPurchaseOrderId) {

        return purchaseOrderMapper.findPurchaseOrderCount2(searchPurchaseOrderId);
    }

    @Override
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public void delPurchaseOrder(String searchPurchaseOrderId) {
        purchaseOrderMapper.deleteByPrimaryKey(searchPurchaseOrderId);
    }

    @Override
    public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderMapper.updateByPrimaryKey(purchaseOrder);
    }

    //备货-------------------------------------------------------------------------
    @Override
    public List<PrepareGoods> findPrepareGoods(Integer page, Integer rows, String searchPrepareGoodsId) {

        int start = (page - 1) * rows;

        return prepareGoodsMapper.findPrepareGoods(start, rows, searchPrepareGoodsId);
    }

    @Override
    public Integer findPrepareGoodsCount(String searchPrepareGoodsId) {
        return prepareGoodsMapper.findPrepareGoodsCount(searchPrepareGoodsId);
    }

    @Override
    public void addPrepareGoods(PrepareGoods prepareGoods) {
        prepareGoodsMapper.insert(prepareGoods);
    }

    @Override
    public void delPrepareGoods(String searchPrepareGoodsId) {
        prepareGoodsMapper.deleteByPrimaryKey(searchPrepareGoodsId);
    }

    @Override
    public void updatePrepareGoods(PrepareGoods prepareGoods) {
        prepareGoodsMapper.updateByPrimaryKey(prepareGoods);
    }

    @Override
    public List<WarehouserType> findWarehouserType() {

        return warehouserTypeMapper.findWarehouserType();
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseMapper.findAll();
    }

    @Override
    public WarehouserType selectByPrimaryKey(Integer warehouserTypeId) {

        return warehouserTypeMapper.selectByPrimaryKey(warehouserTypeId);
    }
}
