package org.java.service.impl;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.TaskQuery;
import org.apache.shiro.SecurityUtils;
import org.java.dao.TakeGoodsMapper;
import org.java.entity.SysUserinfo;
import org.java.entity.TakeGoods;
import org.java.service.TakeGoodsService;
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
public class TakeGoodsServiceImpl implements TakeGoodsService {

    @Autowired
    private TakeGoodsMapper takeGoodsMapper;

    @Autowired
    private TaskService taskService;

    @Transactional
    @Override
    public void addTakeGoods(TakeGoods takeGoods) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        TaskQuery query = taskService.createTaskQuery();

        query.taskCandidateUser(user.getUserName());

        TaskQuery task = query.taskId(takeGoods.getTakeGoodsTaskid());

        if (task != null) {

            taskService.claim(takeGoods.getTakeGoodsTaskid(),user.getUserName());

            taskService.complete(takeGoods.getTakeGoodsTaskid());
        }

        takeGoods.setTakeGoodsId(String.valueOf(UUID.randomUUID()));

        takeGoodsMapper.insert(takeGoods);
    }

    @Override
    public List<TakeGoods> findTakeGoods(Integer page, Integer rows, String searchTakeGoodsId) {
        int start = (page-1)*rows;
        return findTakeGoods(start,rows,searchTakeGoodsId);
    }

    @Override
    public Integer findTakeGoodsCount(String searchTakeGoodsId) {
        return takeGoodsMapper.findTakeGoodsCount(searchTakeGoodsId);
    }
}
