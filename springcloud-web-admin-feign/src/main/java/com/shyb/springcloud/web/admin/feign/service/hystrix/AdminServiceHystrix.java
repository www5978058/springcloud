package com.shyb.springcloud.web.admin.feign.service.hystrix;

import com.shyb.springcloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @author wzh
 * @date 2019/6/16 - 15:35
 */
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHi() {
        return "your request is bad";
    }

    @Override
    public String show(String message) {
        return String.format("your message is %s,but it is bad",message);
    }
}
