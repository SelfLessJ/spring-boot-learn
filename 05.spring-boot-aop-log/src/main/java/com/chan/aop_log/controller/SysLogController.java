package com.chan.aop_log.controller;

import com.chan.aop_log.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chan
 * @create 2020-04-23 10:37
 */
@RestController
public class SysLogController {

    @Log("执行方法一")
    @GetMapping("/one")
    public void methodOne(String name) {
    }

    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) {
    }
}