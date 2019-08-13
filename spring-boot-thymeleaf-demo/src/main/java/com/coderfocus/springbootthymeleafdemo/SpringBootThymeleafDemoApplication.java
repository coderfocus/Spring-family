package com.coderfocus.springbootthymeleafdemo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@SpringBootApplication
public class SpringBootThymeleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThymeleafDemoApplication.class, args);
    }

    /** 
    * @Description: 解决上传文件大于10M出现连接重置的问题。 
    * @param: []
    * @return: org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory 
    * @Author: songwenjie
    * @Date: 2019/8/9 
    */ 
    @Bean
    public TomcatServletWebServerFactory tomcatEmbedded() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }
}
