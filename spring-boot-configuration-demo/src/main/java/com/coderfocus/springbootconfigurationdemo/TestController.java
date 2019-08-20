package com.coderfocus.springbootconfigurationdemo;

import com.coderfocus.springbootconfigurationdemo.config.InfoByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private InfoByValue infoByValue;

    /** 
    * @Description: 通过@Value读取自定义配置属性 
    * @param: []
    * @return: com.coderfocus.springbootconfigurationdemo.config.InfoByValue 
    * @Author: songwenjie
    * @Date: 2019/8/20 
    */ 
    @GetMapping("/infoByValue")
    public InfoByValue infoByValue(){
        return infoByValue;
    }
}
