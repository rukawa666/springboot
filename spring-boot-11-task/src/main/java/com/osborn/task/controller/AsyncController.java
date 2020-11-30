package com.osborn.task.controller;

import com.osborn.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-12-02 15:55
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String sayHello() {
        asyncService.hello();
        return "success";
    }
}
