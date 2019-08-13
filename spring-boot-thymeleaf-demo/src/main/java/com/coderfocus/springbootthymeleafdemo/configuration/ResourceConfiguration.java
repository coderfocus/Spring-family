package com.coderfocus.springbootthymeleafdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/** 
* @Description: 通过继承WebMvcConfigurationSupport扩展自定义配置,会屏蔽默认配置和其他自定义配置
* @param: 
* @return:  
* @Author: songwenjie
* @Date: 2019/8/13 
*/ 
@Configuration
public class ResourceConfiguration extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**")
                .addResourceLocations("file:E:/images/") //指定外部路径
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/META-INF/resources/");//指定类路径
    }
}