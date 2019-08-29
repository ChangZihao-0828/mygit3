package org.java.service;

import org.java.entity.Department;
import org.java.entity.SysPermission;
import org.java.entity.SysUserinfo;

import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/16 16:46
 * @Description: Frighting!!!
 */


public interface UserService {


    public SysUserinfo login(String username);

    public List<String> loadPermission(String id);

    public List<SysPermission> loadMenus(String id);

    public Department findByDempartmentId(Integer id);
}
