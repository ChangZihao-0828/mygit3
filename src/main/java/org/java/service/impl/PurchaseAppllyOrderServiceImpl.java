package org.java.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.PurchaseAppllyOrderMapper;
import org.java.entity.PurchaseAppllyOrder;
import org.java.entity.SysUserinfo;
import org.java.service.PurchaseAppllyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/14 23:32
 * @Description:
 */
@Service
public class PurchaseAppllyOrderServiceImpl implements PurchaseAppllyOrderService {
    @Autowired
    private PurchaseAppllyOrderMapper mapper;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Override
    public List<Map> findGroupPurchaseApplyOrder() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        List<Map> list = new ArrayList<Map>();

        for (Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            PurchaseAppllyOrder purchaseAppllyOrder = mapper.findByProcessinstanceId(processInstanceId);
            Map map = new HashMap();
            map.put("defkey",t.getTaskDefinitionKey());
            map.put("purchaseAppllyTaskid",t.getId());
            if (purchaseAppllyOrder!=null){

                purchaseAppllyOrder.setPurchaseAppllyTaskid(t.getId());

                list.add(map);
            }

        }

        return list;
    }

    @Override
    public int findGroupPurchaseApplyOrderCount() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        return taskList.size();
    }

    @Override
    public void submitPurchaseApplyOrder(String purchaseAppllyTaskid,String defkey) {

        Map<String,Object> variable = new HashMap<String, Object>();

        variable.put("defkey",defkey);
        variable.put("purchaseAppllyTaskid",purchaseAppllyTaskid);

        taskService.complete(purchaseAppllyTaskid,variable);

    }
    @Override
    public List<PurchaseAppllyOrder> findPurchaseAppllyOrderAll(int page, int rows, Integer purchaseAppllyUserName){

        return mapper.findPurchaseAppllyOrder(page,rows,purchaseAppllyUserName);

    }

    @Override
    public int findCount(Integer purchaseAppllyUserName) {

        return mapper.getCount(purchaseAppllyUserName);
    }

    @Override
    public List<PurchaseAppllyOrder> findPurchaseAppllyOrder(int page, int rows, Integer purchaseAppllyUserName) {
        System.out.println("======================");
//        计算开始下标
        int start = (page - 1) * rows;

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        List<PurchaseAppllyOrder> list = new ArrayList<PurchaseAppllyOrder>();

        for (Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            System.out.println(processInstanceId);

            PurchaseAppllyOrder purchaseAppllyOrder = mapper.findByProcessinstanceId(processInstanceId);

            if (purchaseAppllyOrder!=null){

                purchaseAppllyOrder.setPurchaseAppllyTaskid(t.getId());

                list.add(purchaseAppllyOrder);
            }

        }

        return list;
    }
    @Override
    public int getCount(Integer purchaseAppllyUserName) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        taskList.size();

        return  taskList.size();

    }

    @Transactional
    @Override
    public void add(PurchaseAppllyOrder p) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        String id = UUID.randomUUID().toString();

        String processDefinitionKey = "myProcess";

        identityService.setAuthenticatedUserId(user.getUserName());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, id);

        p.setPurchaseAppllyUserName(user.getUserName());

        p.setPurchaseAppllyOrderId(id);

        p.setProcessinstanceId(processInstance.getProcessInstanceId());

        mapper.insert(p);
    }

    @Transactional
    @Override
    public void update(PurchaseAppllyOrder p) {
        mapper.updateByPrimaryKey(p);
    }

    @Transactional
    @Override
    public void del(String purchaseAppllyOrderId) {
        mapper.deleteByPrimaryKey(purchaseAppllyOrderId);
    }

}