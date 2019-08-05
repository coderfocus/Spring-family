package com.coderfocus.springbootthymeleafdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    private Integer count = 0;

    /**
    * @Description: 测试 Controller 默认是不是单例模式（是）
    * @param: []
    * @return: java.lang.Integer
    * @Author: songwenjie
    * @Date: 2019/8/5
    */
    @GetMapping("/count")
    public Integer testSingleton(){
        count+=1;
        return count;
    }
}
