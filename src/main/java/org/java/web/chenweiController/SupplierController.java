package org.java.web.chenweiController;

import org.java.entity.Customer;
import org.java.entity.Supplier;
import org.java.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @ResponseBody
    @RequestMapping("sc")
    public Map getList(Integer page, Integer limit) {
        Map map = new HashMap();

        List<Supplier> list = supplierService.getList(page, limit);//集合
        int count = supplierService.getCount();//总数

        map.put("code", 0);//状态正常
        map.put("msg", "");
        map.put("count", count);//总数
        map.put("data", list);

        return map;
    }

    @RequestMapping("cg1")
    public String cg1() {

        return "customer/supplier";
    }

    @RequestMapping("cg2")
    public String cg2() {

        return "customer/purchase_applly_order";
    }

    @RequestMapping("cg3")
    public String cg3() {

        return "customer/purchase_order";
    }

    @RequestMapping("cg4")
    public String cg4() {

        return "customer/purchase_send";
    }

    @RequestMapping("cg5")
    public String cg5() {

        return "customer/arrival_receipt";
    }

    @RequestMapping("cg6")
    public String cg6() {

        return "customer/arrival_disposal";
    }

    @RequestMapping("cg7")
    public String cg7() {

        return "customer/purchase_applly_order_add";
    }

    @RequestMapping("cg8")
    public String cg8() {

        return "customer/supplier_add";
    }

    @RequestMapping("cg9")
    public String cg9() {

        return "customer/purchase_order_add";
    }

    @RequestMapping("delSupplier")
    @ResponseBody
    public void delSupplier(String supplierId) {

        supplierService.delSupplier(supplierId);
    }

    @RequestMapping("/supplieradd")
    @ResponseBody //一定要添加此注解
    public void edit(Supplier e) {
        if (e.getSupplierId()=="") {
            e.setSupplierId(String.valueOf(UUID.randomUUID()));

            supplierService.add(e);
        } else {
            supplierService.updateSupplier(e);

        }


    }

    @RequestMapping("/supplieradd1")
    @ResponseBody //一定要添加此注解
    public void add(Supplier f) {
    supplierService.add(f);
    }
}