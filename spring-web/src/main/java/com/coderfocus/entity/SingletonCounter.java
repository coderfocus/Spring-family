package com.coderfocus.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SingletonCounter {

    private Integer count;

    public Integer getCount() {
        return count;
    }

    @Value("10")
    public void setCount(Integer count) {
        this.count = count;
    }
}
