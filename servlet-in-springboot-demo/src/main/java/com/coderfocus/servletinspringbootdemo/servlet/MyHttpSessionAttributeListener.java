package com.coderfocus.servletinspringbootdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * Notification that an attribute has been added to a session. Called after
     * the attribute is added.
     * The default implementation is a NO-OP.
     *
     * @param se Information about the added attribute
     */
    public void attributeAdded(HttpSessionBindingEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.log("HttpSessionAttribute was added { name: " + se.getName() + " value: "+ se.getValue() +"}");
    }

    /**
     * Notification that an attribute has been removed from a session. Called
     * after the attribute is removed.
     * The default implementation is a NO-OP.
     *
     * @param se Information about the removed attribute
     */
    public void attributeRemoved(HttpSessionBindingEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.log("HttpSessionAttribute was removed { name: " + se.getName() + " value: "+ se.getValue() +"}");
    }

    /**
     * Notification that an attribute has been replaced in a session. Called
     * after the attribute is replaced.
     * The default implementation is a NO-OP.
     *
     * @param se Information about the replaced attribute
     */
    public void attributeReplaced(HttpSessionBindingEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.log("HttpSessionAttribute was replaced { name: " + se.getName() + " value: "+ se.getValue() +"}");
    }
}
