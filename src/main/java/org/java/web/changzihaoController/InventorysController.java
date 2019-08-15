package org.java.web.changzihaoController;import org.java.entity.MatterCheck;import org.java.entity.MatterReject;import org.java.entity.StockCheck;import org.java.entity.WarehouseCheck;import org.java.service.InventoryService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.*;import java.util.HashMap;import java.util.List;import java.util.Map;/** * @Auther: 昌子豪------ * @Date: 2019/8/11 09:44 * @Description: Frighting!!! */@Controllerpublic class InventorysController {    @Autowired    private InventoryService inventoryService;    @GetMapping("/inventory/{page}")    public String inventory(@PathVariable("page") String page){        return "inventory/"+page;    }    @GetMapping("warehouseCheck")    @ResponseBody    public Map<String,Object> warehouseCheck(){        List<WarehouseCheck> warehouseCheck = inventoryService.findWarehouseCheck();        Integer count = inventoryService.findWarehouseCheckCount();        Map map = new HashMap();        map.put("code",0);//状态正常        map.put("msg","");        map.put("count",count);//总数        map.put("data",warehouseCheck);        System.out.println(map);        return map;    }    @GetMapping("matterCheck")    @ResponseBody    public Map<String,Object> matterCheck(){        List<MatterCheck> warehouseCheck = inventoryService.findMatterCheck();        Integer count = inventoryService.findMatterCheckCount();        Map map = new HashMap();        map.put("code",0);//状态正常        map.put("msg","");        map.put("count",count);//总数        map.put("data",warehouseCheck);        System.out.println(map);        return map;    }    @GetMapping("matterReject")    @ResponseBody    public Map<String,Object> matterScrap(){        List<MatterReject> warehouseCheck = inventoryService.findMatterReject();        Integer count = inventoryService.findMatterRejectCount();        Map map = new HashMap();        map.put("code",0);//状态正常        map.put("msg","");        map.put("count",count);//总数        map.put("data",warehouseCheck);        System.out.println(map);        return map;    }    @GetMapping("stockCheck")    @ResponseBody    public Map<String,Object> stockCheck(){        List<StockCheck> warehouseCheck = inventoryService.findStockCheck();        Integer count = inventoryService.findStockCheckCount();        Map map = new HashMap();        map.put("code",0);//状态正常        map.put("msg","");        map.put("count",count);//总数        map.put("data",warehouseCheck);        System.out.println(map);        return map;    }    @RequestMapping("delWarehouseCheck")    @ResponseBody    public void delWarehouseCheck(String warehouseCheckId){        System.out.println(warehouseCheckId);    }    @RequestMapping("delMatterCheck")    @ResponseBody    public void delMatterCheck(String MatterCheckId){        System.out.println(MatterCheckId);    }    @RequestMapping("delStockCheck")    @ResponseBody    public void delStockCheck(String StockCheckId){        System.out.println(StockCheckId);    }    @RequestMapping("delMatterReject")    @ResponseBody    public void delMatterReject(String MatterRejectId){        System.out.println(MatterRejectId);    }}