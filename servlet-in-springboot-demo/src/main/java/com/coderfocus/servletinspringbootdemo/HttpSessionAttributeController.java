package com.coderfocus.servletinspringbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HttpSessionAttributeController {

    @GetMapping("/httpSession/attribute")
    public void attribute(HttpSession session){
        session.setAttribute("coder","focus");
        session.setAttribute("coder","coderfocus");
        session.setAttribute("coder","focus");
        session.removeAttribute("coder");
    }
}
