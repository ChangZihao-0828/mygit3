package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("login")
    public String logins(){

        return "login";
    }

    @PostMapping("login")
    public String loginss(HttpServletRequest request) throws Exception{

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
}
