package com.coderfocus.controller;

import com.coderfocus.commons.context.AutoSpringContext;
import com.coderfocus.entity.User;
import com.coderfocus.service.PrototypeService;
import com.coderfocus.service.SingletonService;
import com.coderfocus.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ScopeController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //单例 true
        SingletonService singletonService1 = AutoSpringContext.getBean("singletonService");
        SingletonService singletonService2 = AutoSpringContext.getBean("singletonService");
        System.out.println(singletonService1 == singletonService2);

        //原型 false
        PrototypeService prototypeService1 = AutoSpringContext.getBean("prototypeService");
        PrototypeService prototypeService2 = AutoSpringContext.getBean("prototypeService");
        System.out.println(prototypeService1 == prototypeService2);
    }
}
