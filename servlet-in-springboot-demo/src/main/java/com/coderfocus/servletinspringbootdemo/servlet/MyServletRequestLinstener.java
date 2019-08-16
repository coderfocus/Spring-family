package com.coderfocus.servletinspringbootdemo.servlet;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestLinstener implements ServletRequestListener {

    @Override
    public void requestInitialized (ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("request was initialized!");
    }

    @Override
    public void requestDestroyed (ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("request was destroyed!");
    }



}
