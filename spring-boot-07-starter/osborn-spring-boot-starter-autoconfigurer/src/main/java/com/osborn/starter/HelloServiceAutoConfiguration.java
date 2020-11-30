package com.osborn.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 23:45
 */
@Configuration
@ConditionalOnWebApplication   //WEB应用才生效
@EnableConfigurationProperties(HelloProperties.class)   //使HelloProperties对象生效
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean
    public HelloService service() {
        HelloService helloService = new HelloService();
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }
}
