package org.java.web;

import org.apache.shiro.SecurityUtils;
import org.java.entity.SysUserinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/16 20:27
 * @Description: Frighting!!!
 */

@Controller
public class pageController {


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


    @GetMapping("/activiti/{page}")
    public String activity(@PathVariable String page){

        return "/activitiFlow/"+page;
    }
}
