package com.coderfocus.service.impl;

import com.coderfocus.service.Counter;
import org.springframework.stereotype.Component;

@Component
public class AdditionCounter implements Counter {

    public Integer calculate(Integer count) {
        return count + count;
    }
}
