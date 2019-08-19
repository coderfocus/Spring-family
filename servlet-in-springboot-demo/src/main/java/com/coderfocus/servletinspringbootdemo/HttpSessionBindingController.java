package com.coderfocus.servletinspringbootdemo;

import com.coderfocus.servletinspringbootdemo.servlet.MyHttpSessionBindingListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HttpSessionBindingController {

    @GetMapping("/httpSession/binding")
    public void attribute(HttpSession session){
        session.setAttribute("binding",new MyHttpSessionBindingListener());
        session.setAttribute("coder","focus");
        session.setAttribute("coder","coderfocus");
        session.setAttribute("coder","focus");
        session.removeAttribute("coder");
        session.removeAttribute("binding");
    }
}
