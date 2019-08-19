package com.coderfocus.servletinspringbootdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    /**
     * Notification that a new attribute was added to the
     * servlet request. Called after the attribute is added.
     * The default implementation is a NO-OP.
     * @param srae Information about the new request attribute
     */
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        HttpServletRequest request = (HttpServletRequest)srae.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("servelt attributeAdded { name: " + srae.getName() + " value: "+ srae.getValue() +"}");
    }

    /**
     * Notification that an existing attribute has been removed from the
     * servlet request. Called after the attribute is removed.
     * The default implementation is a NO-OP.
     * @param srae Information about the removed request attribute
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        HttpServletRequest request = (HttpServletRequest)srae.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("servelt attributeRemoved { name: " + srae.getName() + " value: "+ srae.getValue() +"}");
    }

    /**
     * Notification that an attribute was replaced on the
     * servlet request. Called after the attribute is replaced.
     * The default implementation is a NO-OP.
     * @param srae Information about the replaced request attribute
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        HttpServletRequest request = (HttpServletRequest)srae.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("servelt attributeReplaced { name: " + srae.getName() + " value: "+ srae.getValue() +"}");
    }
}
