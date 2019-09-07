package com.coderfocus.controller;

import com.coderfocus.commons.context.AutoSpringContext;
import com.coderfocus.entity.PrototypeCounter;
import com.coderfocus.entity.SingletonCounter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AnnotationController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SingletonCounter singletonCounter = AutoSpringContext.getBean("singletonCounter");
        singletonCounter.setCount(singletonCounter.getCount()+1);

        PrototypeCounter prototypeCounter = AutoSpringContext.getBean("prototypeCounter");
        prototypeCounter.setCount(prototypeCounter.getCount()+1);

        PrintWriter writer =resp.getWriter();
        writer.write("singletonCount: "+ singletonCounter.getCount() + "\n");
        writer.write("prototypeCount: "+ prototypeCounter.getCount() + "\n");
    }
}
