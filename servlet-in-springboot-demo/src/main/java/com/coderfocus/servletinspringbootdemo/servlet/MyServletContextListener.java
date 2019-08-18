package com.coderfocus.servletinspringbootdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public  void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.log("context was initialized!");
    }

    @Override
    public  void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.log("context was initialized!");
    }
}
