package com.osborn.springboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 23:08
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("CommandLineRunner...run...");
    }
}
