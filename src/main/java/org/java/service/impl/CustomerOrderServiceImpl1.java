package org.java.service.impl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.shiro.SecurityUtils;
import org.java.dao.CustomerOrderMapper1;
import org.java.entity.CustomerOrder;
import org.java.entity.SysUserinfo;
import org.java.service.CustomerOrderService;
import org.java.service.CustomerOrderService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/17 15:10
 * @Description: Frighting!!!
 */

@Service
public class CustomerOrderServiceImpl1 implements CustomerOrderService1 {

    @Autowired
    private CustomerOrderMapper1 customerOrderMapper;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;


    @Override
    public List<CustomerOrder> getList(int page, int rows) {
        int start = (page-1)*rows;
        return customerOrderMapper.getList(0,4);
    }

    @Override
    public int getCount() {
        return customerOrderMapper.getCount();
    }


    @Transactional
    @Override
    public void add(CustomerOrder f) {

        SysUserinfo user = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();

        String id = UUID.randomUUID().toString();

        String processDefinitionKey = "myProcess";

        identityService.setAuthenticatedUserId(user.getUserName());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, id);

        f.setCustomerOrderNameId(user.getUserName());

        f.setCustomerOrderId(id);

        f.setProcessinstanceId(processInstance.getProcessInstanceId());

        customerOrderMapper.insert(f);
    }
}
