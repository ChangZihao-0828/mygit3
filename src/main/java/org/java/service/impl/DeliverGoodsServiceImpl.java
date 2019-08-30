package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.DeliverGoodsMapper;
import org.java.entity.DeliverGoods;
import org.java.entity.OutGoods;
import org.java.entity.SysUserinfo;
import org.java.service.DeliverGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/16 12:46
 * @Description:
 */
@Service
public class DeliverGoodsServiceImpl implements DeliverGoodsService {
    @Autowired
    private DeliverGoodsMapper mapper;

    @Autowired
    private TaskService taskService;

    @Override
    public void submitDeliveryOrder(String outGoodsTaskid) {

        taskService.complete(outGoodsTaskid);

    }

    @Override
    public List<DeliverGoods> findDeliverGoods(int page, int rows, String deliverGoodsId) {

        int start = (page - 1) * rows;

        return mapper.findDeliverGoods(start,rows,deliverGoodsId);
    }

    @Override
    public List<DeliverGoods> findDeliverGoods2() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        List<DeliverGoods> list = new ArrayList<DeliverGoods>();

        for(Task t:taskList) {

            String processInstanceId = t.getProcessInstanceId();

            System.out.println("process="+processInstanceId);

            DeliverGoods deliverGoods = mapper.selectByProcessinstanceId(processInstanceId,"未配送");

            if (deliverGoods!=null){

                list.add(deliverGoods);
            }

        }
        return list;
    }

    @Override
    public int getDeliverGoodsCount(String deliverGoodsId) {
        return mapper.getDeliverGoodsCount(deliverGoodsId);
    }

    @Transactional
    @Override
    public void add(DeliverGoods d) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        TaskQuery task = query.taskId(d.getDeliverGoodsTaskid());

        if (task != null) {

            taskService.claim(d.getDeliverGoodsTaskid(),user.getUserName());

        }
        d.setDeliverGoodsId(String.valueOf(UUID.randomUUID()));

        d.setDeliverGoodsStatus("未配送");

        mapper.insert(d);
    }

    @Transactional
    @Override
    public void update(DeliverGoods d) {
        mapper.updateByPrimaryKey(d);
    }

    @Transactional
    @Override
    public void updateState(DeliverGoods deliverGoods) {

        mapper.updateByPrimaryKeySelective(deliverGoods);
    }

    @Transactional
    @Override
    public void del(String deliverGoodsId) {
        mapper.deleteByPrimaryKey(deliverGoodsId);
    }
}
