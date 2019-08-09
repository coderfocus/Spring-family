package com.coderfocus.springbootthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaticController {
    @PostMapping("/echo")
    public String echo(User model) {
        System.out.println(model);
        return "/success";
    }
}
