package com.coderfocus.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
    }

    public static Object getBean(String beanId){
        return context.getBean(beanId);
    }

}
