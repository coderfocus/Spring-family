package com.coderfocus.service.impl;

import com.coderfocus.service.Counter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SquareCounter implements Counter {

    public Integer calculate(Integer count) {
        return count * count;
    }
}
