package com.coderfocus.controller;

import com.coderfocus.dto.User;
import com.coderfocus.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"","/login"},method = RequestMethod.GET)
    public String login(){
        loginService.login();
        return "login";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(){
        User user = new User();
        user.setName("coderfocus");
        user.setAge(18);
        return ResponseEntity.ok(user);
    }
}
