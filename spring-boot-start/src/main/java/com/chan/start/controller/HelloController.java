package com.chan.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chan
 * @create 2020-04-20 20:44
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello Spring Boot";
    }
}
