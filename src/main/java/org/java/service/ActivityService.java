package org.java.service;

import org.java.entity.CustomerOrder;
import org.java.entity.PurchaseAppllyOrder;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/20 14:33
 * @Description: Frighting!!!
 */


public interface ActivityService {
    //根据用户名，查询待办任务
    public List<CustomerOrder> showPersonTask();
    //返回的所有，正在运行中的流程实例（客户）
    public List<CustomerOrder> showProcessInstance();
    //返回的所有，正在运行中的流程实例（采购申请）
    public List<PurchaseAppllyOrder> showProcessInstance2();

    public Map<String,Object> showActiveMap(String processinstanceId);
    //提交采购单，同时，设置流程变量
    public void submitOrder(String taskid,String price);
    //查询当前用户可以拾取的任务
    public List<CustomerOrder> showCliamTask();
    //拾取任务
    public void claimTask(String taskId);

    //提交审核意见
    public void submitAudit(Map<String,Object> map);


}
