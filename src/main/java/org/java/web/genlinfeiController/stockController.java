package org.java.web.genlinfeiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class stockController {
    @GetMapping("/stock/{page}")
    public String stock(@PathVariable("page") String page){

        System.out.println("***********");
        return "stock/"+page;
    }
}
