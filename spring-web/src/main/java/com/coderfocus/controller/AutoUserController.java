package com.coderfocus.controller;

import com.coderfocus.commons.context.AutoSpringContext;
import com.coderfocus.entity.User;
import com.coderfocus.service.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AutoUserController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = AutoSpringContext.getBean("userService");

        User user = userService.getUser();
        PrintWriter writer =resp.getWriter();
        writer.write("name:"+ user.getName() +", email: " +user.getEmail());
    }

}
