package com.coderfocus.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SquareCounter {

    public Integer square(Integer count) {
        return count * count;
    }
}
