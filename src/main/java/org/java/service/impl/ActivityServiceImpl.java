package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.CustomerOrderMapper;
import org.java.entity.CustomerOrder;
import org.java.entity.SysUserinfo;
import org.java.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Map<String, Object>> showPersonTask() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

        for(Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            CustomerOrder customerOrder = customerOrderMapper.selectByProcessinstanceId(processInstanceId);

//            map.put("taskId",t.getId());
//
//            map.put("taskName",t.getName());
//
//            map.put("processInstanceId",t.getProcessInstanceId());
//
//            map.put("taskDefinitionKey",t.getTaskDefinitionKey());
//
//            list.add(map);







        }


        return null;
    }
}
