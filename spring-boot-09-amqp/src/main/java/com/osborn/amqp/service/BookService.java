package com.osborn.amqp.service;

import com.osborn.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-12-02 7:50
 */
@Service
public class BookService {

    @RabbitListener(queues = "steven.news")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }


    @RabbitListener(queues = "steven")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
