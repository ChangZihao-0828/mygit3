package org.java.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.PurchaseOrderMapper;
import org.java.entity.PurchaseOrder;
import org.java.entity.SysUserinfo;
import org.java.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 00:17
 * @Description:
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderMapper Mapper;
    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;
    @Transactional
    @Override
    public List<PurchaseOrder> findPurchaseOrder(int page, int rows, String purchaseUserId) {
        //        计算开始下标
        int start = (page - 1) * rows;
        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();
        TaskQuery query = taskService.createTaskQuery();
        query.taskAssignee(user.getUserName());
        List<Task> taskList = query.list();
        List<PurchaseOrder> list = new ArrayList<PurchaseOrder>();
        for (Task t:taskList){

            String processinstanceId = t.getProcessInstanceId();

            PurchaseOrder purchaseOrder = Mapper.findByProcessinstanceId(processinstanceId);

            if (purchaseOrder!=null){

                purchaseOrder.setPurchaseTaskid(t.getId());

                list.add(purchaseOrder);
            }

        }
        return list;
    }
    @Transactional
    @Override
    public void add(PurchaseOrder e) {
        Mapper.insert(e);
    }
    @Transactional
    @Override
    public int getPurchaseOrderCount(String purchaseOrderId) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        taskList.size();

        return  taskList.size();

    }
    @Transactional
    @Override
    public void updatePurchaseOrder(PurchaseOrder e) {
    Mapper.updateByPrimaryKeySelective(e);
    }
    @Transactional
    @Override
    public int delPurchaseOrder(String purchaseOrderId) {
        return Mapper.deleteByPrimaryKey(purchaseOrderId);
    }

    @Override
    public void submitPurchaseOrder(String purchaseTaskid, String purchasePrice) {

        float pri = Float.parseFloat(purchasePrice);

        Map<String,Object> variable = new HashMap<String, Object>();

        variable.put("price",pri);

        taskService.complete(purchaseTaskid,variable);

    }

    @Override
    public List<PurchaseOrder> findPurchaseOrderAll(int page, int rows, String purchaseOrderId) {
        return Mapper.findPurchaseOrder(page,rows,purchaseOrderId);
    }

    @Override
    public int findCount(String purchaseUserId) {
        return Mapper.getPurchaseOrderCount(purchaseUserId);
    }

    @Override
    public List<PurchaseOrder> findGroupPurchaseOrder() {
        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        List<PurchaseOrder> list = new ArrayList<PurchaseOrder>();

        for (Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            PurchaseOrder purchaseOrder = Mapper.findByProcessinstanceId(processInstanceId);

            if (purchaseOrder!=null){

                purchaseOrder.setPurchaseTaskid(t.getId());

                list.add(purchaseOrder);
            }

        }

        return list;
    }

    @Override
    public int findGroupOrderCount() {
        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        return taskList.size();
    }

}
