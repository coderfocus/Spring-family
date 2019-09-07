package com.coderfocus.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SingletonCounter {

    private Integer count;

    @Autowired
    private SquareCounter squareCounter;

    public Integer getCount() {
        return count;
    }

    @Value("10")
    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer square(Integer count) {
        return squareCounter.square(count);
    }
}
