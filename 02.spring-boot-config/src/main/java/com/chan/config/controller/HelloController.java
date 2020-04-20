package com.chan.config.controller;

import com.chan.config.peoperties.GetConfigProperties;
import com.chan.config.peoperties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chan
 * @create 2020-04-20 21:04
 */
@RestController
public class HelloController {

    @Autowired
    private GetConfigProperties properties;

    @Autowired
    private UserProperties user;

    @GetMapping("hello")
    public String hello(){
        return "Hello Spring Boot";
    }

    @GetMapping("properties")
    public String getProperties(){
        return properties.toString();
    }

    @GetMapping("user")
    public String getUser(){
        return user.toString();
    }
}
