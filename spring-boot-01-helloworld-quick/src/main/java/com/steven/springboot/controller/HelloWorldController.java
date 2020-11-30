package com.steven.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-01 8:01
 */
/*@Controller
@ResponseBody*/
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world quick";
    }
}
