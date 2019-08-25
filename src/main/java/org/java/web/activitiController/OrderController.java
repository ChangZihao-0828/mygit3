package org.java.web.activitiController;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.java.entity.CustomerOrder;
import org.java.entity.PurchaseAppllyOrder;
import org.java.service.ActivityService;
import org.java.service.CustomerOrderService;
import org.java.service.CustomerOrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/14 20:30
 * @Description: Frighting!!!
 */

@Controller
public class OrderController {


    @Autowired
    private TaskService taskService;

    @Autowired
    private HttpSession ses;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CustomerOrderService1 customerOrderService1;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private RuntimeService runtimeService;


    @PostMapping("createOrder")
    public String createOrder(CustomerOrder customerOrder){

        customerOrderService1.add(customerOrder);

        return "redirect:showPersonTask";

    }

    @GetMapping("showPersonTask")
    public String showPersonTask(Model model){

        List<CustomerOrder> list = activityService.showPersonTask();

        model.addAttribute("list",list);

        return "/activitiOrder/showPersonTask";
    }
//
    @GetMapping("showProcessInstance")
    public String showProcessInstance(Model model){

        List<CustomerOrder> list = activityService.showProcessInstance();

        List<Map<String,Object>> l = new ArrayList<Map<String,Object>>();

        for (CustomerOrder c:list){

            Map map = new HashMap();


                map.put("orderId",c.getCustomerOrderId());

                map.put("processinstanceid",c.getProcessinstanceId());

                map.put("price",c.getCustomerOrderPrice());

                map.put("createtime",c.getCustomerGetgoodstime());

                map.put("endtime",c.getCustomerOrderTime());

                map.put("username",c.getCustomerOrderNameId());

                map.put("defkey",c.getCustomerOrderState());

                l.add(map);


        }

        model.addAttribute("list",l);

        return "/activitiOrder/showProcessInstance";
    }

    @GetMapping("showProcessInstance2")
    public String showProcessInstance2(Model model){

        List<PurchaseAppllyOrder> list = activityService.showProcessInstance2();

        List<Map<String,Object>> l = new ArrayList<Map<String,Object>>();

        for (PurchaseAppllyOrder p:list){

            Map map = new HashMap();

                map.put("orderId",p.getPurchaseAppllyOrderId());

                map.put("processinstanceid",p.getProcessinstanceId());

                map.put("price",p.getPurchaseAppllyPrice());

                map.put("createtime",p.getPurchaseAppllyOrderBegintime());

                map.put("endtime",p.getPurchaseAppllyOrderEndtime());

                map.put("username",p.getPurchaseAppllyUserName());

                l.add(map);



        }

        model.addAttribute("list",l);

        return "/activitiOrder/showProcessInstance2";
    }


    @GetMapping("delProcessInstance/{processinstanceId}")
    public void delProcessInstance(String processinstanceId){

        runtimeService.deleteProcessInstance(processinstanceId,"数据异常");

    }

    @GetMapping("submitorder/{taskId}/{price}")
    public String submitOrder(@PathVariable("taskId") String taskId, @PathVariable("price") String price){

        float pri = Float.parseFloat(price);

        activityService.submitOrder(taskId,price);

        return "redirect:/showPersonTask";

    }

    @GetMapping("showHistoryTask/{processInstanceId}")
    public String showHistoryTask(@PathVariable("processInstanceId") String processInstanceId, Model model){

        HistoricTaskInstanceQuery query= historyService.createHistoricTaskInstanceQuery();

        List<HistoricTaskInstance> HistoryList =  query.processInstanceId(processInstanceId).list();

        model.addAttribute("list",HistoryList);

        return "/activitiOrder/showHistoryTask";

    }

    @GetMapping("showActiveMap/{processInstanceId}")
    public String showActiveMap(@PathVariable("processInstanceId") String processInstanceId, Model model){

        Map<String, Object> map = activityService.showActiveMap(processInstanceId);

        model.addAttribute("m",map);

        return "/activitiFlow/showActiveMap";

    }
//
//    @GetMapping("audit/{taskId}/{id}/{taskDefinitionKey}")
//    public String audit(@PathVariable("taskId") String taskId, @PathVariable("id") String id, @PathVariable("taskDefinitionKey") String taskDefinitionKey, Model model){
//
//        String userId = (String) ses.getAttribute("user");
//
//        Map<String, Object> map = infService.audit(id);
//
//        map.put("userId",userId);
//
//        map.put("taskId",taskId);
//
//        map.put("orderId",id);
//
//        map.put("taskDefinitionKey",taskDefinitionKey);
//
//        model.addAttribute("m",map);
//
//        return "/order/submitAudit";
//    }
//
//
//    @PostMapping("submitAudit")
//    public String submitAudit(@RequestParam Map<String,Object> map){
//
//        String userId = (String) ses.getAttribute("user");
//
//        map.put("userId",userId);
//
//        infService.submitAudit(map);
//
//        return "redirect:showPersonTask";
//
//    }

    @GetMapping("showClaimTask")
    public String showClaimTask(Model model){

        List<CustomerOrder> list = activityService.showCliamTask();

        model.addAttribute("list",list);

        return "/activitiOrder/showClaimTask";

    }


    @GetMapping("claimTask/{taskId}")
    public String claimTask(@PathVariable("taskId") String taskId){

        activityService.claimTask(taskId);

        return "redirect:/showClaimTask";

    }

}
