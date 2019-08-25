package org.java.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.CustomerOrderMapper;
import org.java.dao.PurchaseAppllyOrderMapper;
import org.java.entity.Customer;
import org.java.entity.CustomerOrder;
import org.java.entity.PurchaseAppllyOrder;
import org.java.entity.SysUserinfo;
import org.java.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/20 14:34
 * @Description: Frighting!!!
 */

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private PurchaseAppllyOrderMapper purchaseAppllyOrderMapper;

    @Override
    public List<CustomerOrder> showPersonTask() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        List<CustomerOrder> list = new ArrayList<CustomerOrder>();

        for(Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            CustomerOrder customerOrder = customerOrderMapper.selectByProcessinstanceId(processInstanceId);

            customerOrder.setCustomerOrderTaskid(t.getId());

            customerOrder.setProcessinstanceId(t.getProcessInstanceId());

            list.add(customerOrder);
        }

        return list;
    }

    @Override
    public List<PurchaseAppllyOrder> showProcessInstance2() {

        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();

        List<ProcessInstance> processInstanceList = query.list();

        List<PurchaseAppllyOrder> list = new ArrayList<PurchaseAppllyOrder>();

        for (ProcessInstance i:processInstanceList){

            String processInstanceId = i.getProcessInstanceId();

            PurchaseAppllyOrder p =  purchaseAppllyOrderMapper.findByProcessinstanceId(processInstanceId);

            if (p!=null){

                list.add(p);
            }

        }

        return list;
    }

    @Override
    public List<CustomerOrder> showProcessInstance() {

        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();

        List<ProcessInstance> processInstanceList = query.list();

        List<CustomerOrder> list = new ArrayList<CustomerOrder>();

        for (ProcessInstance i:processInstanceList){

            String processInstanceId = i.getProcessInstanceId();

            CustomerOrder customerOrder =  customerOrderMapper.selectByProcessinstanceId(processInstanceId);

            if (customerOrder!=null){

                customerOrder.setCustomerOrderState(i.getActivityId());

                list.add(customerOrder);
            }


        }

        return list;
    }

    @Override
    public Map<String, Object> showActiveMap(String processinstanceId) {
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();

        ProcessInstance instance = query.processInstanceId(processinstanceId).singleResult();

        String processDefinitionId = instance.getProcessDefinitionId();

        ProcessDefinitionEntity entity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);

        String activityId = instance.getActivityId();

        ActivityImpl activity = entity.findActivity(activityId);

        int height = activity.getHeight();

        int width = activity.getWidth();

        int x = activity.getX();

        int y = activity.getY();

        String deploymentId = entity.getDeploymentId();

        String png = entity.getDiagramResourceName();

        Map<String,Object> map = new HashMap<String, Object>();

        map.put("h",height);
        map.put("w",width);
        map.put("x",x);
        map.put("y",y);
        map.put("deploymentId",deploymentId);
        map.put("png",png);

        return map;
    }

    @Override
    public void submitOrder(String taskid, String price) {

        Map<String,Object> variable = new HashMap<String, Object>();

        variable.put("price",price);

        taskService.complete(taskid,variable);
    }

    @Override
    public List<CustomerOrder> showCliamTask() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        List<CustomerOrder> list = new ArrayList<CustomerOrder>();

        for (Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            CustomerOrder customerOrder = customerOrderMapper.selectByProcessinstanceId(processInstanceId);

            customerOrder.setCustomerOrderTaskid(t.getId());

            list.add(customerOrder);

        }

        return list;
    }

    @Override
    public void claimTask(String taskId) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        TaskQuery task = query.taskId(taskId);

        if (task != null) {

            taskService.claim(taskId,user.getUserName());

        }
    }
}
