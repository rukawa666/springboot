package com.osborn.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-12-02 16:50
 */
@Service
public class ScheduledService {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    /**
     * second、minute、hour, day of month, month、day of week.
     * 0 * * * * MON-FRI:周一到周五整秒启动
     */
//    @Scheduled(cron = "0 * * * * SUN")
//    @Scheduled(cron = "0,1,2,3,4,5 * * * * SUN")  //指定时间执行
//    @Scheduled(cron = "0-59 * * * * SUN")   //区间执行
    @Scheduled(cron = "0/4 * * * * SUN")   //每4秒执行一次
    public void hello() {
        System.out.println("定时任务执行，现在时间是 : " + format.format(new Date()));
//        System.out.println("定时任务执行，现在时间是 : " + Instant.now());
        System.out.println("hello osborn ...");
    }
}
