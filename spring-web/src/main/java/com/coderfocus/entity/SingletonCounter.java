package com.coderfocus.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SingletonCounter {
    private Integer count;

    public SingletonCounter(){
        this.count = 0;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
