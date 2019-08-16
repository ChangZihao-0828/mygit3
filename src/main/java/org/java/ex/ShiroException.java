package org.java.ex;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 马果
 * @Date: 2019/7/28 10:35
 * @Description:
 */
@Component
public class ShiroException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //获得异常信息
        String msg = e.getMessage();

        //创建modelAndView
        ModelAndView mv = new ModelAndView("/err");
        mv.addObject("msg",msg );

        return mv;
    }
}
