package com.coderfocus.servletinspringbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ServletRequestAttributeController {

    @GetMapping("/attribute")
    public void addAttribute(HttpServletRequest request){
        request.setAttribute("name","coderfocus");
        request.setAttribute("name","coder");
        request.setAttribute("name","coderfocus");
        request.removeAttribute("name");
    }

}
