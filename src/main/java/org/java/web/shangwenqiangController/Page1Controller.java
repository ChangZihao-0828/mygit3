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
    @GetMapping("/deliver/{page}")
    public String deliver(@PathVariable("page") String page){

        System.out.println("----###--");
        return "deliver/"+page;
    }
    @GetMapping("/carDispatch/{page}")
    public String carDispatch(@PathVariable("page") String page){

        System.out.println("----###--");
        return "carDispatch/"+page;
    }
    @GetMapping("/carDeployLine/{page}")
    public String carDeployLine(@PathVariable("page") String page){

        System.out.println("----###--");
        return "carDeployLine/"+page;
    }
    @GetMapping("/carManager/{page}")
    public String carManager(@PathVariable("page") String page){

        System.out.println("----###--");
        return "carManager/"+page;
    }
    @GetMapping("/carManagerIn/{page}")
    public String carManagerIn(@PathVariable("page") String page){

        System.out.println("----###--");
        return "carManagerIn/"+page;
    }
}
