package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.CarDispatchMapper;
import org.java.dao.DeliverGoodsMapper;
import org.java.entity.CarDispatch;
import org.java.entity.DeliverGoods;
import org.java.entity.OutGoods;
import org.java.entity.SysUserinfo;
import org.java.service.CarDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/17 20:38
 * @Description:
 */
@Service
public class CarDispatchServicemImpl implements CarDispatchService {

    @Autowired
    private CarDispatchMapper mapper;

    @Autowired
    private TaskService taskService;

    @Autowired
    private DeliverGoodsMapper deliverGoodsMapper;


    @Override
    public List<CarDispatch> findCarDispatch(int page, int rows, String carDispatchId) {
        //计算开始下标
        int start = (page-1)*rows;

        return mapper.findCarDispatch(start,rows,carDispatchId);
    }

    @Override
    public int getCarDispatchCount(String carDispatchId) {
        return mapper.getCarDispatchCount(carDispatchId);
    }

    @Transactional
    @Override
    public void add(CarDispatch c) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        TaskQuery task = query.taskId(c.getCarDispatchTaskid());

        if (task != null) {

            taskService.claim(c.getCarDispatchTaskid(),user.getUserName());

            taskService.complete(c.getCarDispatchTaskid());
        }

        c.setCarDispatchId(String.valueOf(UUID.randomUUID()));

        c.setCarDispatchStatus("已调度");

        mapper.insert(c);
    }

    @Transactional
    @Override
    public void update(CarDispatch c) {
        mapper.updateByPrimaryKey(c);
    }

    @Override
    public void del(String carDispatchId) {
        mapper.deleteByPrimaryKey(carDispatchId);
    }

    @Override
    public List<DeliverGoods> finddeliverGoodsByProcessinstanceId(String state) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        List<Task> taskList = query.list();

        List<DeliverGoods> list = new ArrayList<DeliverGoods>();

        for (Task t:taskList){

            String processInstanceId = t.getProcessInstanceId();

            DeliverGoods deliverGoods = deliverGoodsMapper.selectByProcessinstanceId(processInstanceId,state);

            if (deliverGoods!=null){

                deliverGoods.setDeliverGoodsTaskid(t.getId());

                list.add(deliverGoods);

            }
        }

        return list;

    }
}
