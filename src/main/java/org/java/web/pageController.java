package org.java.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.java.entity.SysUserinfo;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/16 20:27
 * @Description: Frighting!!!
 */

@Controller
public class pageController {

    @Autowired
    private UserService userService;


    @GetMapping("/forword/{page}")
    public String forword(@PathVariable("page") String page){

        return "/"+page;
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request) throws Exception{

        SysUserinfo users = (SysUserinfo) SecurityUtils.getSubject().getPrincipal();


        //获得错误信息shiroLoginFailure,如果是由于没有登录，进入控制器，该值为null
        String err = (String) request.getAttribute("shiroLoginFailure");

        //判断消息是否为空
        if(err!=null){
            if(err.endsWith("UnknownAccountException")){
                throw new Exception("用户名不存在...");
            }
            if(err.endsWith("IncorrectCredentialsException")){
                throw new Exception("密码错误");
            }
        }

        return "/login";
    }


    @GetMapping("/activitiFlow/{page}")
    public String activityFlow(@PathVariable String page){

        return "/activitiFlow/"+page;
    }

    @GetMapping("/activitiOrder/{page}")
    public String activityOrder(@PathVariable String page){

        return "/activitiOrder/"+page;
    }

    @GetMapping("/")
    public String first(HttpSession session){

        //获得认证成功的主体
        Subject subject = SecurityUtils.getSubject();

        //从主体获得用户的主要凭证（就是认证方法，返回的SimpleAuthencationInfo对象的第一个参数，map）
        SysUserinfo sysUserinfo = (SysUserinfo) subject.getPrincipal();

        String username = sysUserinfo.getUserName();

//          List<Map> menus = (List<Map>) map.get("menus");
//
            session.setAttribute("user", username);
//          session.setAttribute("menus",menus );

            return "/index";
    }

    @GetMapping("/adminInfo")
    public String adminInfo(HttpSession session){

        Subject subject = SecurityUtils.getSubject();

        //从主体获得用户的主要凭证（就是认证方法，返回的SimpleAuthencationInfo对象的第一个参数，map）
        SysUserinfo sysUserinfo = (SysUserinfo) subject.getPrincipal();


        session.setAttribute("username",sysUserinfo.getUserName());
        session.setAttribute("department",userService.findByDempartmentId(Integer.valueOf(sysUserinfo.getUserDepartment())).getDepartmentName());
        session.setAttribute("tel",sysUserinfo.getUserTel());
        session.setAttribute("permission",userService.loadMenus(sysUserinfo.getUserId()));


        return "/admin_info";

    }
}
