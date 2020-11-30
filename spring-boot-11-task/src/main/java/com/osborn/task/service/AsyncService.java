package com.osborn.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-12-02 15:53
 */
@Service
public class AsyncService {

    //告诉spring这是一个异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中...");
    }
}
