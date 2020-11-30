package com.steven.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableAutoConfiguration注解：开启自动配置注解
 */

@SpringBootApplication
public class SpringBoot02ConfigAutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02ConfigAutoconfigApplication.class, args);
    }
}
