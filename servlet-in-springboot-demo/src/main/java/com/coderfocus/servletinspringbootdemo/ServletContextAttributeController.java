package com.coderfocus.servletinspringbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ServletContextAttributeController {
    @GetMapping("/servletContext/attribute")
    public void attribute(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name","coderfocus");
        servletContext.setAttribute("name","coder");
        servletContext.setAttribute("name","coderfocus");
        servletContext.removeAttribute("name");
    }
}
