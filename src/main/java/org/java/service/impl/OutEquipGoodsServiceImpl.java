package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.OutEquipGoodsMapper;
import org.java.entity.OutEquipGoods;
import org.java.entity.SysUserinfo;
import org.java.service.OutEquipGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/19 10:47
 * @Description: Frighting!!!
 */

@Service
public class OutEquipGoodsServiceImpl implements OutEquipGoodsService {


    @Autowired
    private OutEquipGoodsMapper outEquipGoodsMapper;

    @Autowired
    private TaskService taskService;

    @Transactional
    @Override
    public void addOutEquipGoods(OutEquipGoods outEquipGoods) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        TaskQuery task = query.taskId(outEquipGoods.getOutEquipGoodsTaskid());

        if (task != null) {

            taskService.claim(outEquipGoods.getOutEquipGoodsTaskid(),user.getUserName());

            taskService.complete(outEquipGoods.getOutEquipGoodsTaskid());
        }
        outEquipGoods.setOutEquipGoodsId(String.valueOf(UUID.randomUUID()));

        outEquipGoods.setOutEquipGoodsStatus("已装卸");

        outEquipGoodsMapper.updateByPrimaryKeySelective(outEquipGoods);

    }

    @Override
    public List<OutEquipGoods> findOutEquipGoods(Integer page, Integer rows, String searchOutEquipGoodsId) {
        int start = (page-1)*rows;

        return outEquipGoodsMapper.findOutEquipGoods(start,rows,searchOutEquipGoodsId);
    }

    @Override
    public Integer findOutEquipGoodsCount(String searchOutEquipGoodsId) {

        return outEquipGoodsMapper.findOutEquipGoodsCount(searchOutEquipGoodsId);
    }
}
