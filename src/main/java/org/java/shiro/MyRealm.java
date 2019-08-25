package org.java.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.java.entity.SysPermission;
import org.java.entity.SysUserinfo;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 马果
 * @Date: 2019/7/28 10:17
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("###########从数据库中加载用户权限#####################");

        //获得用户的主要凭证信息
        SysUserinfo user = (SysUserinfo) principals.getPrimaryPrincipal();

        List<String> list = userService.loadPermission(user.getUserId());

        System.out.println(list);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermissions(list);

        return info;

    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("进入shiro---------------------------");
        //获得用户凭证
        String principal = (String) token.getPrincipal();

        //根据用户凭证（用户名）到数据库中，判断用是否存在

        SysUserinfo user = userService.login(principal);

        if(user==null){

            return null;//用户名不存在

        }

        //获得正确密码
        String pwd = (String) user.getUserPwd();

        //设置盐
        String salt = "d102";

        //返回AuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd, ByteSource.Util.bytes(salt), "myrealm" );

        return info;

    }
}
