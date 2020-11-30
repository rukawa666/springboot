package com.osborn.springboot.controller;

import com.osborn.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-14 0:08
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/sayHello")
    public String hello() {
        return helloService.sayHello("坚持不懈");
    }
}
