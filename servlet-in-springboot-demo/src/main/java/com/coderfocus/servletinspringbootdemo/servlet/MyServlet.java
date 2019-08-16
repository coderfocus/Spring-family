package com.coderfocus.servletinspringbootdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name="myServlet",urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Writer writer = response.getWriter();
        writer.write("<html><body><h3>hello, my servlet</h3></body></html>");
    }
}
