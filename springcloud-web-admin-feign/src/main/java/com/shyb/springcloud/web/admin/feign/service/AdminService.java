package com.shyb.springcloud.web.admin.feign.service;

import com.shyb.springcloud.web.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wzh
 * @date 2019/6/16 - 15:16
 */
@FeignClient(value = "SPRINGCLOUD-SERVICE-ADMIN",fallback = AdminServiceHystrix.class)
public interface AdminService {
    @GetMapping("/")
    public String sayHi();

    /**
     * 需要使用@RequestParam注解，该注解作为参数传递
     * @param message
     * @return
     */
    @GetMapping("/show")
    public String show(@RequestParam("message") String message);
}
