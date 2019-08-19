package com.coderfocus.servletinspringbootdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/** 
* @Description: 从监听范围上比较，HttpSessionListener设置一次就可以监听所有session，HttpSessionBindingListener通常都是一对一的。
 * 适合更精确控制 Session 的场景，比如在线人数统计
* @param: 
* @return:  
* @Author: songwenjie
* @Date: 2019/8/19 
*/ 
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
    /**
     * Notifies the object that it is being bound to a session and identifies
     * the session.
     * The default implementation is a NO-OP.
     *
     * @param event
     *            the event that identifies the session
     * @see #valueUnbound
     */
    public void valueBound(HttpSessionBindingEvent event) {
        ServletContext servletContext = event.getSession().getServletContext();
        servletContext.log("HttpSessionBinding was bounded { name: " + event.getName() + " value: "+ event.getValue() +"}");
    }

    /**
     * Notifies the object that it is being unbound from a session and
     * identifies the session.
     * The default implementation is a NO-OP.
     *
     * @param event
     *            the event that identifies the session
     * @see #valueBound
     */
    public void valueUnbound(HttpSessionBindingEvent event) {
        ServletContext servletContext = event.getSession().getServletContext();
        servletContext.log("HttpSessionBinding was unbounded { name: " + event.getName() + " value: "+ event.getValue() +"}");
    }
}
