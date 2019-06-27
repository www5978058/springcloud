package com.shyb.springcloud.web.admin.feign.controller;

import com.shyb.springcloud.web.admin.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @date 2019/6/16 - 15:17
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/")
    public String sayHi(){
        return adminService.sayHi();
    }
    @GetMapping("/show")
    public String show(String message){
        return adminService.show(message);
    }
}
