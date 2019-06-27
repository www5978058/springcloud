package com.shyb.springcloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @date 2019/6/4 - 10:38
 */
@RestController
public class AdminController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String hello(){
        return "你的端口是"+port;
    }

    @GetMapping("/show")
    public String show(String message){
        return "你的消息是"+message+",端口是"+port;
    }
}
