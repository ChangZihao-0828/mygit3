package org.java.web.activitiController;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/14 20:30
 * @Description: Frighting!!!
 */

@Controller
public class OrderController {


//    @Autowired
//    private InfServic infService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HttpSession ses;

    @Autowired
    private HistoryService historyService;

//
//    @PostMapping("createOrder")
//    public String createOrder(@RequestParam Map<String,Object> map){
//
//        infService.createOrder(map);
//
//        return "redirect:showPersonTask";
//
//    }
//
//    @GetMapping("showPersonTask")
//    public String showPersonTask(Model model){
//
//        List<Map<String, Object>> list = infService.showPersonTask();
//
//        model.addAttribute("list",list);
//
//        return "/order/showPersonTask";
//    }
//
//    @GetMapping("showProcessInstance")
//    public String showProcessInstance(Model model){
//
//        List<Map<String, Object>> list = infService.showProcessInstance();
//
//        model.addAttribute("list",list);
//
//        return "/order/showProcessInstance";
//    }
//
//
//    @GetMapping("submitorder/{taskId}/{price}")
//    public String submitOrder(@PathVariable("taskId") String taskId, @PathVariable("price") String price){
//
//        float pri = Float.parseFloat(price);
//
//        infService.submitOrder(taskId,pri);
//
//        return "redirect:/showPersonTask";
//
//    }
//
//
//    @GetMapping("showHistoryTask/{processInstanceId}")
//    public String showHistoryTask(@PathVariable("processInstanceId") String processInstanceId, Model model){
//
//        HistoricTaskInstanceQuery query= historyService.createHistoricTaskInstanceQuery();
//
//        List<HistoricTaskInstance> HistoryList =  query.processInstanceId(processInstanceId).list();
//
//        model.addAttribute("list",HistoryList);
//
//        return "/order/showHistoryTask";
//
//    }
//
//    @GetMapping("showActiveMap/{processInstanceId}")
//    public String showActiveMap(@PathVariable("processInstanceId") String processInstanceId, Model model){
//
//        Map<String, Object> map = infService.showActiveMap(processInstanceId);
//
//        model.addAttribute("m",map);
//
//        return "/flow/showActiveMap";
//
//    }
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
//
//    @GetMapping("showClaimTask")
//    public String showClaimTask(Model model){
//
//        String userId = (String) ses.getAttribute("user");
//
//        List<Map<String, Object>> list = infService.showCliamTask(userId);
//
//        model.addAttribute("list",list);
//
//        return "/order/showClaimTask";
//
//    }
//
//
//    @GetMapping("claimTask/{taskId}")
//    public String claimTask(@PathVariable("taskId") String taskId){
//
//        String userId = (String) ses.getAttribute("user");
//
//        infService.claimTask(taskId,userId);
//
//        return "redirect:/showClaimTask";
//
//    }
//
//
//    @GetMapping("settlement/{taskId}")
//    public String settlement(@PathVariable("taskId") String taskId){
//
//        infService.settlement(taskId);
//
//        return "redirect:/showPersonTask";
//    }
//
//    @GetMapping("storage/{taskId}")
//    public String stroage(@PathVariable("taskId") String taskId){
//
//        infService.storage(taskId);
//
//        return "redirect:/showPersonTask";
//    }
}
