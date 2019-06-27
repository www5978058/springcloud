package com.shyb.springcloud.web.admin.ribbon.controller;

import com.shyb.springcloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wzh
 * @date 2019/6/16 - 15:03
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String hello(){
        return adminService.hello();
    }

    @GetMapping("/show")
    public String show(String message){
        return adminService.show(message);
    }
}
