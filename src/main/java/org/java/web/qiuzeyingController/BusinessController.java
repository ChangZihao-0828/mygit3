package org.java.web.qiuzeyingController;

import org.java.entity.*;
import org.java.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

        return "module/" + page;
    }

    //仓库管理-------------------------------------------------------------------------
    @GetMapping("/warehouse")
    @ResponseBody
    public Map<String, Object> warehouse(Integer page, Integer limit, String searchWarehouseId) {

        List<Warehouse> warehouse = businessService.findWarehouse(page, limit, searchWarehouseId);

        List<Map> list = new ArrayList<Map>();

        for (Warehouse w:warehouse){

            Map m = new HashMap();

            m.put("warehouseId",w.getWarehouseId());
            m.put("warehouseName",w.getWarehouseName());
            m.put("warehouseArea",w.getWarehouseArea());
            m.put("warehouseType",businessService.findWarehouseTypeById(w.getWarehouseType()).getWarehousertypeState());
            m.put("warehouseAddress",w.getWarehouseAddress());
            m.put("warehouseEnable",w.getWarehouseEnable());
            m.put("warehouseBuildDate",w.getWarehouseBuildDate());
            m.put("warehouseManager",w.getWarehouseManager());
            m.put("warehouseTypeId",w.getWarehouseType());
            list.add(m);

        }

        Integer count = businessService.findWarehouseCount(searchWarehouseId);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", list);

        return map;
    }

    @GetMapping("/addWarehouse")
    @ResponseBody
    public void addWarehouse(Warehouse warehouse,String province,String city,String district) {

        if (warehouse.getWarehouseId() == "") {

            warehouse.setWarehouseId(String.valueOf(UUID.randomUUID()));

            warehouse.setWarehouseAddress(province+city+district);

            businessService.addWarehouse(warehouse);

        } else {

            warehouse.setWarehouseAddress(province+city+district);

            businessService.updateWarehouse(warehouse);

        }

    }

    @RequestMapping("/delWarehouse")
    @ResponseBody
    public void delWarehouse(String warehouseId) {

        businessService.delWarehouse(warehouseId);

        List<WarehouseRegion> list = businessService.findWarehouseRegionByWarehouseName(warehouseId);

        for (WarehouseRegion w:list){

            businessService.delWarehouseRegion(w.getWarehouseRegionId());

        }

        List<WarehousePosition> list2 = businessService.findWarehousePositionByByWarehouseId(warehouseId);

        for (WarehousePosition w2:list2){

            businessService.delWarehousePosition(w2.getWarehousePositionId());

        }


    }

    //区域管理-------------------------------------------------------------------------
    @GetMapping("/warehouseRegion")
    @ResponseBody
    public Map<String, Object> warehouseRegion(Integer page, Integer limit, String searchWarehouseRegionId) {

        List<WarehouseRegion> warehouseRegion = businessService.findWarehouseRegion(page, limit, searchWarehouseRegionId);

        List<Map> list = new ArrayList<Map>();

        for (WarehouseRegion w:warehouseRegion){

            Map map = new HashMap();

            map.put("warehouseRegionId",w.getWarehouseRegionId());
            map.put("warehouseRegionName",w.getWarehouseRegionName());
            map.put("warehouseRegionArea",w.getWarehouseRegionArea());
            map.put("warehouseId",businessService.findWarehouseById(w.getWarehouseId()).getWarehouseName());
            map.put("warehouseRegionBuildDate",w.getWarehouseRegionBuildDate());
            list.add(map);
        }

        Integer count = businessService.findWarehouseRegionCount(searchWarehouseRegionId);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", list);

        return map;
    }

    @GetMapping("/addWarehouseRegion")
    @ResponseBody
    public void addWarehouseRegion(WarehouseRegion warehouseRegion) {

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

        List<WarehousePosition> list = businessService.findWarehousePositionByByWarehouseRegionId(warehouseRegionId);

        for (WarehousePosition w:list){

            businessService.delWarehousePosition(w.getWarehousePositionId());


        }
    }

    //仓位管理-------------------------------------------------------------------------
    @GetMapping("/warehousePosition")
    @ResponseBody
    public Map<String, Object> warehousePosition(Integer page, Integer limit, String searchWarehousePositionId) {

        List<WarehousePosition> warehousePosition = businessService.findWarehousePosition(page, limit, searchWarehousePositionId);

        List<Map> list = new ArrayList<Map>();

        for (WarehousePosition w:warehousePosition){

            Map map = new HashMap();
            map.put("warehousePositionId",w.getWarehousePositionId());
            map.put("warehousePositionRegionId",businessService.findWarehouseRegionById(w.getWarehousePositionRegionId()).getWarehouseRegionName());
            map.put("warehouseId",businessService.findWarehouseById(w.getWarehouseId()).getWarehouseName());
            map.put("warehousePositionArea",w.getWarehousePositionArea());
            map.put("warehousePositionBuildDate",w.getWarehousePositionBuildDate());
            list.add(map);

        }


        Integer count = businessService.findWarehousePositionCount(searchWarehousePositionId);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", list);

        return map;
    }

    @GetMapping("/addWarehousePosition")
    @ResponseBody
    public void addWarehousePosition(WarehousePosition warehousePosition) {

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

        List<Map> list = new ArrayList<>();

        for (Car c:car){

            Map map = new HashMap();

            map.put("carId",c.getCarId());
            map.put("carTypeId",businessService.findCarTypeById(c.getCarTypeId()).getCartypeState());
            map.put("carBrand",c.getCarBrand());
            map.put("motorcadeId",businessService.findMotorcadeById(c.getMotorcadeId()).getMotorcadeName());
            map.put("carLoad",c.getCarLoad());
            map.put("carBulk",c.getCarBulk());
            map.put("carState",c.getCarState());
            list.add(map);

        }

        Integer count = businessService.findCarCount(searchCarId);

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", list);

        return map;
    }

    @GetMapping("/addCar")
    @ResponseBody
    public void addCar(Car car) {

        if (car.getCarId()==null) {

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

        Map map = new HashMap();

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", purchaseOrder);

        return map;
    }

    @GetMapping("/addPurchaseOrder")
    @ResponseBody
    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {

        if (purchaseOrder.getPurchaseOrderId() == "") {

            purchaseOrder.setPurchaseOrderId(String.valueOf(UUID.randomUUID()));

            businessService.addPurchaseOrder(purchaseOrder);

        } else {

            businessService.updatePurchaseOrder(purchaseOrder);

        }

    }

    @RequestMapping("/delPurchaseOrder1")
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

        return map;
    }

    @GetMapping("/addPrepareGoods")
    @ResponseBody
    public void addPrepareGoods(PrepareGoods prepareGoods) {

        if (prepareGoods.getPrepareGoodsId() == "") {

            prepareGoods.setPrepareGoodsId(String.valueOf(UUID.randomUUID()));

            businessService.addPrepareGoods(prepareGoods);

        } else {

            businessService.updatePrepareGoods(prepareGoods);

        }

    }

    @RequestMapping("/delPrepareGoods1")
    @ResponseBody
    public void delPrepareGoods(String prepareGoodsId) {

        businessService.delPrepareGoods(prepareGoodsId);

    }

    @GetMapping("/findWarehouseType")
    @ResponseBody
    public List<Map<String,Object>> findWarehouseType(){

        List<WarehouserType> list =  businessService.findWarehouserType();

        List<Map<String,Object>> l = new ArrayList<Map<String, Object>>();

        for (WarehouserType t:list){

            Map<String,Object> map = new HashMap<String, Object>();

            map.put("state",t.getWarehousertypeState());
            map.put("id",t.getWarehouserTypeId());

            l.add(map);

        }
        System.out.println(l);
        return l;
    }

    @GetMapping("/findWarehouse")
    @ResponseBody
    public List<Map> findWarehouse(){

        List<Warehouse> list =  businessService.findAll();

        List<Map> l = new ArrayList<Map>();

        for (Warehouse t:list){

            Map m = new HashMap();

            m.put("name",t.getWarehouseName());
            m.put("id",t.getWarehouseId());

            l.add(m);

        }

        return l;
    }

    @GetMapping("/findWarehouseRegion")
    @ResponseBody
    public List<Map> findWarehouseRegion(String warehouseId){

        List<WarehouseRegion> list =  businessService.findWarehouseRegionByWarehouseName(warehouseId);

        List<Map> l = new ArrayList<Map>();

        for (WarehouseRegion t:list){

            Map m = new HashMap();

            m.put("name",t.getWarehouseRegionName());
            m.put("id",t.getWarehouseRegionId());

            l.add(m);

        }

        return l;
    }

    @GetMapping("/findMotorcade")
    @ResponseBody
    public List<Map> findMotorcade(){

        List<Motorcade> list =  businessService.findMotorcade();

        List<Map> l = new ArrayList<Map>();

        for (Motorcade motorcade:list){

            Map m = new HashMap();

            m.put("name",motorcade.getMotorcadeName());
            m.put("id",motorcade.getMotorcadeId());

            l.add(m);

        }

        return l;

    }

    @GetMapping("/findCarType")
    @ResponseBody
    public List<Map> findCarType(){

        List<Cartype> list =  businessService.findCarType();

        List<Map> l = new ArrayList<Map>();

        for (Cartype c:list){

            Map m = new HashMap();

            m.put("state",c.getCartypeState());
            m.put("id",c.getCartypeId());

            l.add(m);

        }

        return l;

    }
}
