package com.osborn.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1、RabbitAutoConfiguration
 * 2、CachingConnectionFactory
 * 3、RabbitProperties：封装了RabbitMQ的配置
 * 4、RabbitTemplate：发送和接收消息
 * 5、AmqpAdmin：系统管理组件
 *      创建和删除Queue、Exchange、Binding
 * 6.@EnableRabbit + @RabbitListener来监听消息队列的内容
 */

@SpringBootApplication
@EnableRabbit   //开启基于注解的rabbitMQ模式
public class SpringBoot09AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09AmqpApplication.class, args);
    }
}
