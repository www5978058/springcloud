package com.shyb.springcloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wzh
 * @date 2019/6/16 - 14:59
 */
@Service
public class AdminService {
    private static final String ADMIN_SERVER_URL = "http://SPRINGCLOUD-SERVICE-ADMIN/";
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(){
        return restTemplate.getForObject(ADMIN_SERVER_URL,String.class);
    }
    @HystrixCommand(fallbackMethod = "showError")
    public String show(String message){
        return restTemplate.getForObject("http://SPRINGCLOUD-SERVICE-ADMIN/show?message="+message,String.class);
    }
    public String hiError(){
        return "your request bad";
    }

    public String showError(String message){
        return String.format("your message is %s, but your request bad",message);
    }
}
