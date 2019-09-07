package com.coderfocus.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Scope("prototype")
@Component
public class PrototypeCounter {

    private Integer count;

    public Integer getCount() {
        return count;
    }

    @Value("10")
    public void setCount(Integer count) {
        this.count = count;
    }

    @PostConstruct
    public void setUp(){
        System.out.println("PrototypeCounter setUp!!!");
    }
}
