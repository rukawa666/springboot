package com.osborn.springboot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 23:07
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments arguments) throws Exception {
        System.out.println("ApplicationRunner...run...");
    }
}
