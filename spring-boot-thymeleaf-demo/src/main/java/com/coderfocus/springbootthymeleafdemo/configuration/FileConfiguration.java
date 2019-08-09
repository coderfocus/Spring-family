package com.coderfocus.springbootthymeleafdemo.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileConfiguration {

    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大2M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(2, DataUnit.MEGABYTES));
        //设置总上传数据总大小3M
        factory.setMaxRequestSize(DataSize.of(3, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

}
