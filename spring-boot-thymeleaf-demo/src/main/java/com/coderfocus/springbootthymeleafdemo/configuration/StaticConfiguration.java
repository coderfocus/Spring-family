package com.coderfocus.springbootthymeleafdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class StaticConfiguration implements WebMvcConfigurer {
    /** 
    * @Description:
     * Spring Boot 默认为我们提供了静态资源处理，使用 WebMvcAutoConfiguration 中的配置各种属性
     * 如果我们想自定义静态资源映射目录的话，只需重写addResourceHandlers方法即可
     * 通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径
     *  会覆盖Spring Boot默认的静态资源处理（WebMvcAutoConfiguration）
    * @param: [registry]
    * @return: void 
    * @Author: songwenjie
    * @Date: 2019/8/12 
    */ 
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
