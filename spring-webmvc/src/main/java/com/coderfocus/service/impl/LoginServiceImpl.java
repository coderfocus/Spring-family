package com.coderfocus.service.impl;

import com.coderfocus.service.LoginService;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {
    public void login() {
        System.out.println("login");
    }
}
