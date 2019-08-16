package com.coderfocus.servletinspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.coderfocus.servletinspringbootdemo.servlet"})
public class ServletInSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletInSpringbootDemoApplication.class, args);
    }

}
