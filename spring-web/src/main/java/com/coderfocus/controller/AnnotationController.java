package com.coderfocus.controller;

import com.coderfocus.commons.context.AutoSpringContext;
import com.coderfocus.service.impl.PrototypeCounter;
import com.coderfocus.service.impl.SingletonCounter;

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

        Integer squareCount1 = singletonCounter.square(singletonCounter.getCount());
        Integer squareCount2 = singletonCounter.squareCount(singletonCounter.getCount());
        Integer addCount = singletonCounter.addCount(singletonCounter.getCount());

        PrintWriter writer =resp.getWriter();
        writer.write("singletonCount: "+ singletonCounter.getCount() + "\n");
        writer.write("prototypeCount: "+ prototypeCounter.getCount() + "\n");
        writer.write("squareCount1: "+ squareCount1 + "\n");
        writer.write("squareCount2: "+ squareCount2 + "\n");
        writer.write("addCount: "+ addCount + "\n");
    }
}
