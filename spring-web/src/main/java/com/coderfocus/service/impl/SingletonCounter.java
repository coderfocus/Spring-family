package com.coderfocus.service.impl;

import com.coderfocus.service.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SingletonCounter {

    private Integer count;

    @Autowired
    private SquareCounter squareCounter1;

//    @Qualifier("squareCounter")
//    @Autowired
    @Resource
    private Counter squareCounter;

//    @Qualifier("additionCounter")
//    @Autowired
    @Resource
    private Counter additionCounter;

    public Integer getCount() {
        return count;
    }

    @Value("10")
    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer square(Integer count) {
        return squareCounter1.calculate(count);
    }

    public Integer squareCount(Integer count) {
        return squareCounter.calculate(count);
    }

    public Integer addCount(Integer count) {
        return additionCounter.calculate(count);
    }
}
