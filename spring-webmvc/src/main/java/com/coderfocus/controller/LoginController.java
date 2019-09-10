package com.coderfocus.controller;

import com.coderfocus.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"","/login"},method = RequestMethod.GET)
    public String login(){
        loginService.login();
        return "login";
    }
}
