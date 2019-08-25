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

    public List<CustomerOrder> showPersonTask();

    public List<CustomerOrder> showProcessInstance();

    public List<PurchaseAppllyOrder> showProcessInstance2();

    public Map<String,Object> showActiveMap(String processinstanceId);

    public void submitOrder(String taskid,String price);

    public List<CustomerOrder> showCliamTask();

    public void claimTask(String taskId);

}
