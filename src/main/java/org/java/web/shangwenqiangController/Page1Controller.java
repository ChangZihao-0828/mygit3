package org.java.web.shangwenqiangController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Title:
 * @Author:
 * @Date: 2019/8/15 22:04
 * @Description:
 */
@Controller
public class Page1Controller {
    @GetMapping("/order/{page}")
    public String order(@PathVariable("page") String page){

        System.out.println("----###--");
        return "order/"+page;
    }
}
