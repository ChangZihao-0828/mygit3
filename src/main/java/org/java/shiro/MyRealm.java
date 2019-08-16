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
import org.java.entity.SysUserinfo;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

//        System.out.println("###########从数据库中加载用户权限#####################");
//
//        //获得用户的主要凭证信息
//        Map principal = (Map) principals.getPrimaryPrincipal();
//
//        //获得用户的id
//        Integer userId = (Integer) principal.get("id");
//
//        //根据用户id,查询用户权限
//        List<String> list = userService.loadPermission(userId);
//
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        info.addStringPermissions(list);
//
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

//        //获得用户的id
//        Integer userId = Integer.valueOf(user.getUserId());

        //获得当前用户可以访问的菜单
//        List<Map> menus = userService.loadMenus(userId);
//
//        //把菜单放在user中
//        user.put("menus",menus );


        //返回AuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd, ByteSource.Util.bytes(salt), "myrealm" );

        return info;

    }
}
