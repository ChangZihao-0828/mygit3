package org.java.service.impl;

import org.java.dao.DepartmentMapper;
import org.java.dao.SysPermissionMapper;
import org.java.dao.SysUserinfoMapper;
import org.java.entity.Department;
import org.java.entity.SysPermission;
import org.java.entity.SysUserinfo;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/16 16:47
 * @Description: Frighting!!!
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserinfoMapper sysUserinfoMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public SysUserinfo login(String username) {

        return sysUserinfoMapper.login(username);
    }

    @Override
    public List<String> loadPermission(String id) {

        return sysPermissionMapper.loadPermission(id);
    }

    @Override
    public List<SysPermission> loadMenus(String id) {

        return sysPermissionMapper.loadMenus(id);
    }

    @Override
    public Department findByDempartmentId(Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }
}
