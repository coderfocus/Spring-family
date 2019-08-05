package com.coderfocus.springbootthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/error1")
    public String error1(){
        return "/errorPage";
    }

    @GetMapping("/error2")
    public String error2(){
        return "/a/errorPage";
    }
}
