package com.osborn.amqp;

import com.osborn.amqp.bean.Book;
import com.rabbitmq.client.AMQP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot09AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        Exchange exchange = new DirectExchange("amqpAdmin.exchange");
        amqpAdmin.declareExchange(exchange);

        System.out.println("create finished");
    }

    @Test
    public void createQueue() {
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));

        System.out.println("create finished");
    }

    @Test
    public void createBinding() {
        Map<String, Object> map = new HashMap<>();
        Binding binding = new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,
                "amqpAdmin.exchange", "amqp.zwbs", null);
        amqpAdmin.declareBinding(binding);

        System.out.println("create finished");
    }

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //msg需要自己构建一个，定义消息体内容和消息头

        //Object默认当成消息体。只需要传入要发送的对象，自动序列化发送给rabbitMQ
//        rabbitTemplate.send(exchange, routekey, msg);
        Map<String, Object> msg = new HashMap<>();
        msg.put("msg", "这是第一个MQ消息");
        msg.put("data", Arrays.asList("helloworld", 123, true));
        Book book = new Book(1,"数据结构与算法分析");
        //对象被默认序列化以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct", "steven.news", msg);
        rabbitTemplate.convertAndSend("exchange.direct", "steven.news", book);
    }

    /**
     * 接收数据，将数据自动的转为json发送出去
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("steven.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book(2, "Java编程思想"));
    }

}
