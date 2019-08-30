package org.java.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.CustomerOrderMapper;
import org.java.entity.CustomerOrder;
import org.java.entity.SysUserinfo;
import org.java.service.ActivityService;
import org.java.service.CustomerOrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/17 15:10
 * @Description: Frighting!!!
 */

@Service
public class CustomerOrderServiceImpl1 implements CustomerOrderService1 {


    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ActivityService activityService;


    @Override
    public void updateCustomerOrderState(CustomerOrder customerOrder) {

        customerOrderMapper.updateByPrimaryKeySelective(customerOrder);

    }

    @Override
    public List<CustomerOrder> getList(String state) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        List<CustomerOrder> list = new ArrayList<CustomerOrder>();

        for (Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            CustomerOrder customerOrder = customerOrderMapper.selectByProcessinstanceId(processInstanceId,state);

                if (customerOrder!=null){

                    customerOrder.setCustomerOrderTaskid(t.getId());

                    list.add(customerOrder);
            }

        }



        return list;
    }



    @Transactional
    @Override
    public void add(CustomerOrder f) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        String id = UUID.randomUUID().toString();

        String processDefinitionKey = "myProcess1";

        identityService.setAuthenticatedUserId(user.getUserName());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, id);

        f.setCustomerOrderNameId(user.getUserName());

        f.setCustomerOrderId(id);

        f.setProcessinstanceId(processInstance.getProcessInstanceId());

        f.setCustomerOrderState("未接收");

            customerOrderMapper.insert(f);

            TaskQuery query = taskService.createTaskQuery();

            query.taskAssignee(user.getUserName());

            List<Task> taskList = query.list();

            for(Task t:taskList){

                activityService.submitOrder(t.getId(),f.getCustomerOrderPrice());

        }

    }

    @Override
    public void acceptCustomerOrder(CustomerOrder c) {

        taskService.complete(c.getCustomerOrderTaskid());

        c.setCustomerOrderState("已接收");

        customerOrderMapper.updateByPrimaryKeySelective(c);

    }

}
