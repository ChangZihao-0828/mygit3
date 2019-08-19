package org.java.service.impl;

import org.java.dao.SysUserinfoMapper;
import org.java.entity.SysUserinfo;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/16 16:47
 * @Description: Frighting!!!
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserinfoMapper sysUserinfoMapper;

    @Override
    public SysUserinfo login(String username) {

        return sysUserinfoMapper.login(username);
    }
}
