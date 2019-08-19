package org.java.web.qiuzeyingController;

import org.java.entity.*;
import org.java.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author：邱泽英
 * @Date：2019/8/15 19:30
 * @Description：文件
 */
@Controller
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/forward/{page}")
    public String forward(@PathVariable("page") String page) {

        System.out.println(page);
        return "module/" + page;
    }

    //仓库管理-------------------------------------------------------------------------
    @GetMapping("/warehouse")
    @ResponseBody
    public Map<String, Object> warehouse(Integer page, Integer limit, String searchWarehouseId) {

        List<Warehouse> warehouse = businessService.findWarehouse(page, limit, searchWarehouseId);

        Integer count = businessService.findWarehouseCount(searchWarehouseId);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", warehouse);

        System.out.println(warehouse);
        System.out.println(map);
        return map;
    }

    @GetMapping("/addWarehouse")
    @ResponseBody
    public void addWarehouse(Warehouse warehouse) {
        System.out.println(warehouse.getWarehouseId());

        if (warehouse.getWarehouseId() == "") {

            warehouse.setWarehouseId(String.valueOf(UUID.randomUUID()));

            businessService.addWarehouse(warehouse);

        } else {

            businessService.updateWarehouse(warehouse);

        }

    }

    @RequestMapping("/delWarehouse")
    @ResponseBody
    public void delWarehouse(String warehouseId) {

        businessService.delWarehouse(warehouseId);

    }

    //区域管理-------------------------------------------------------------------------
    @GetMapping("/warehouseRegion")
    @ResponseBody
    public Map<String, Object> warehouseRegion(Integer page, Integer limit, String searchWarehouseRegionId) {

        List<WarehouseRegion> warehouseRegion = businessService.findWarehouseRegion(page, limit, searchWarehouseRegionId);

        Integer count = businessService.findWarehouseRegionCount(searchWarehouseRegionId);

        System.out.println(count);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", warehouseRegion);

        System.out.println(warehouseRegion);
        System.out.println(map);
        return map;
    }

    @GetMapping("/addWarehouseRegion")
    @ResponseBody
    public void addWarehouseRegion(WarehouseRegion warehouseRegion) {
        System.out.println(warehouseRegion.getWarehouseRegionId());

        if (warehouseRegion.getWarehouseRegionId() == "") {

            warehouseRegion.setWarehouseRegionId(String.valueOf(UUID.randomUUID()));

            businessService.addWarehouseRegion(warehouseRegion);

        } else {

            businessService.updateWarehouseRegion(warehouseRegion);

        }

    }

    @RequestMapping("/delWarehouseRegion")
    @ResponseBody
    public void delWarehouseRegion(String warehouseRegionId) {

        businessService.delWarehouseRegion(warehouseRegionId);

    }

    //仓位管理-------------------------------------------------------------------------
    @GetMapping("/warehousePosition")
    @ResponseBody
    public Map<String, Object> warehousePosition(Integer page, Integer limit, String searchWarehousePositionId) {

        List<WarehousePosition> warehousePosition = businessService.findWarehousePosition(page, limit, searchWarehousePositionId);

        Integer count = businessService.findWarehousePositionCount(searchWarehousePositionId);

        System.out.println(count);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", warehousePosition);

        System.out.println(warehousePosition);
        System.out.println(map);
        return map;
    }

    @GetMapping("/addWarehousePosition")
    @ResponseBody
    public void addWarehousePosition(WarehousePosition warehousePosition) {
        System.out.println(warehousePosition.getWarehousePositionId());

        if (warehousePosition.getWarehousePositionId() == "") {

            warehousePosition.setWarehousePositionId(String.valueOf(UUID.randomUUID()));

            businessService.addWarehousePosition(warehousePosition);

        } else {

            businessService.updateWarehousePosition(warehousePosition);

        }

    }

    @RequestMapping("/delWarehousePosition")
    @ResponseBody
    public void delWarehousePosition(String warehousePositionId) {

        businessService.delWarehousePosition(warehousePositionId);

    }

    //车辆管理-------------------------------------------------------------------------
    @GetMapping("/car")
    @ResponseBody
    public Map<String, Object> car(Integer page, Integer limit, Integer searchCarId) {

        List<Car> car = businessService.findCar(page, limit, searchCarId);

        Integer count = businessService.findCarCount(searchCarId);

        System.out.println(count);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", car);

        System.out.println(car);
        System.out.println(map);
        return map;
    }

    @GetMapping("/addCar")
    @ResponseBody
    public void addCar(Car car) {
        System.out.println(car.getCarId());

        if (String.valueOf(car.getCarId()).equals("")) {

            car.setCarId(null);

            businessService.addCar(car);

        } else {

            businessService.updateCar(car);

        }

    }

    @RequestMapping("/delCar")
    @ResponseBody
    public void delCar(Integer carId) {

        businessService.delCar(carId);

    }

    //订单接收-------------------------------------------------------------------------
    @GetMapping("/purchaseOrder")
    @ResponseBody
    public Map<String, Object> purchaseOrder(Integer page, Integer limit, String searchPurchaseOrderId) {

        List<PurchaseOrder> purchaseOrder = businessService.findPurchaseOrder2(page, limit, searchPurchaseOrderId);

        Integer count = businessService.findPurchaseOrderCount2(searchPurchaseOrderId);

        System.out.println(count);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", purchaseOrder);

        System.out.println(purchaseOrder);
        System.out.println(map);
        return map;
    }

    @GetMapping("/addPurchaseOrder")
    @ResponseBody
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        System.out.println(purchaseOrder.getPurchaseOrderId());

        if (purchaseOrder.getPurchaseOrderId() == "") {

            purchaseOrder.setPurchaseOrderId(String.valueOf(UUID.randomUUID()));

            businessService.addPurchaseOrder(purchaseOrder);

        } else {

            businessService.updatePurchaseOrder(purchaseOrder);

        }

    }

    @RequestMapping("/delPurchaseOrder")
    @ResponseBody
    public void delPurchaseOrder(String purchaseOrderId) {

        businessService.delPurchaseOrder(purchaseOrderId);

    }

    //备货-------------------------------------------------------------------------
    @GetMapping("/prepareGoods")
    @ResponseBody
    public Map<String, Object> prepareGoods(Integer page, Integer limit, String searchPrepareGoodsId) {

        List<PrepareGoods> prepareGood = businessService.findPrepareGoods(page, limit, searchPrepareGoodsId);

        Integer count = businessService.findPrepareGoodsCount(searchPrepareGoodsId);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", prepareGood);

        System.out.println(prepareGood);
        System.out.println(map);
        return map;
    }

    @GetMapping("/addPrepareGoods")
    @ResponseBody
    public void addPrepareGoods(PrepareGoods prepareGoods) {
        System.out.println(prepareGoods.getPrepareGoodsId());

        if (prepareGoods.getPrepareGoodsId() == "") {

            prepareGoods.setPrepareGoodsId(String.valueOf(UUID.randomUUID()));

            businessService.addPrepareGoods(prepareGoods);

        } else {

            businessService.updatePrepareGoods(prepareGoods);

        }

    }

    @RequestMapping("/delPrepareGoods")
    @ResponseBody
    public void delPrepareGoods(String prepareGoodsId) {

        businessService.delPrepareGoods(prepareGoodsId);

    }
}
