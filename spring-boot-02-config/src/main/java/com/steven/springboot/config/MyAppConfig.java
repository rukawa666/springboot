package com.steven.springboot.config;

import com.steven.springboot.service.HelloWorldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-03 7:27
 *
 * @Configuration:提示当前类是一个配置类；来代替之前的spring文件
 * @Bean：将方法的返回值加入到容器中；容器中这个组件默认的id就是方法名
 */
@Configuration
public class MyAppConfig {

    @Bean
    public HelloWorldService helloWorldService() {
         return new HelloWorldService();
    }
}
