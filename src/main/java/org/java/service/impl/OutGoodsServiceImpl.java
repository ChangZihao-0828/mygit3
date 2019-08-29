package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.OutGoodsMapper;
import org.java.dao.TakeGoodsMapper;
import org.java.entity.OutGoods;
import org.java.entity.SysUserinfo;
import org.java.entity.TakeGoods;
import org.java.service.OutGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 09:29
 * @Description: Frighting!!!
 */

@Service
public class OutGoodsServiceImpl implements OutGoodsService {

    @Autowired
    private OutGoodsMapper outGoodsMapper;

    @Autowired
    private TakeGoodsMapper takeGoodsMapper;

    @Autowired
    private TaskService taskService;

    @Transactional
    @Override
    public void addDeliveryReceiving(OutGoods outGoods) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        TaskQuery task = query.taskId(outGoods.getOutGoodsTaskid());

        if (task != null) {

            taskService.claim(outGoods.getOutGoodsTaskid(),user.getUserName());

        }

        outGoods.setOutGoodsId(String.valueOf(UUID.randomUUID()));

        outGoods.setOutGoodsStatus("未出库");

        outGoodsMapper.insert(outGoods);
    }


    @Override
    public List<OutGoods> findOutGoods(Integer page, Integer rows, String searchDeliveryReceivingId,String outGoodsStatus) {

        int start = (page-1)*rows;

        return outGoodsMapper.findOutGoods(start,rows,searchDeliveryReceivingId,outGoodsStatus);
    }

    @Override
    public List<OutGoods> findOutGoods2() {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskAssignee(user.getUserName());

        List<Task> taskList = query.list();

        List<OutGoods> list = new ArrayList<OutGoods>();

        for(Task t:taskList) {

            String processInstanceId = t.getProcessInstanceId();

            OutGoods outGoods = outGoodsMapper.findOutGoodsByProcessinstanceId("未出库",processInstanceId);

            if (outGoods!=null){

                list.add(outGoods);
            }

        }
        return list;
    }

    @Override
    public List<OutGoods> findOutGoodsByProcessinstanceId(String state) {

            SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

            TaskQuery query = taskService.createTaskQuery();

            query.taskCandidateUser(user.getUserName());

            List<Task> taskList = query.list();

            List<OutGoods> list = new ArrayList<OutGoods>();

            for (Task t:taskList){

                String processInstanceId = t.getProcessInstanceId();

                System.out.println("process=="+processInstanceId);

                OutGoods outGoods =outGoodsMapper.findOutGoodsByProcessinstanceId(state,processInstanceId);

                if (outGoods!=null){

                    outGoods.setOutGoodsTaskid(t.getId());

                    list.add(outGoods);
                }
            }


            return list;

    }

    @Override
    public Integer findOutGoodsCount(String searchDeliveryReceivingId,String outGoodsStatus) {

        return outGoodsMapper.findOutGoodsCount(searchDeliveryReceivingId,outGoodsStatus);
    }

    @Override
    public void updateOutGoodsStatus(OutGoods record) {

        outGoodsMapper.updateByPrimaryKeySelective(record);
    }
}
