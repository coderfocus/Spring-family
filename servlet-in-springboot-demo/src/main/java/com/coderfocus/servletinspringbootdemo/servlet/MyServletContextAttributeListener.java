package com.coderfocus.servletinspringbootdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Notification that a new attribute was added to the servlet context.
     * Called after the attribute is added.
     * The default implementation is a NO-OP.
     * @param scae Information about the new attribute
     */
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        servletContext.log("serveltContext attributeAdded { name: " + scae.getName() + " value: "+ scae.getValue() +"}");
    }

    /**
     * Notification that an existing attribute has been removed from the servlet
     * context. Called after the attribute is removed.
     * The default implementation is a NO-OP.
     * @param scae Information about the removed attribute
     */
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        servletContext.log("serveltContext attributeRemoved { name: " + scae.getName() + " value: "+ scae.getValue() +"}");
    }

    /**
     * Notification that an attribute on the servlet context has been replaced.
     * Called after the attribute is replaced.
     * The default implementation is a NO-OP.
     * @param scae Information about the replaced attribute
     */
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        servletContext.log("serveltContext attributeReplaced { name: " + scae.getName() + " value: "+ scae.getValue() +"}");
    }
}
