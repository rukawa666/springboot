package com.steven.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring的配置文件的加载位置，高优先级的配置内容会被先加载
 * 优先级从高到低：
 *  - file:./config
 *  - file:./
 *  - classpath:/config/
 *  - classpath:/
 */

@SpringBootApplication
public class SpringBoot02Config02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02Config02Application.class, args);
    }
}
