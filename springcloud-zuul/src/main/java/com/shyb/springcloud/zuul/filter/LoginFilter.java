package com.shyb.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wzh
 * @date 2019/6/17 - 15:31
 */
@Component
@Slf4j
public class LoginFilter extends ZuulFilter {
    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 配置过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 配置是否需要过滤：true/需要，false/不需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (token == null) {
            log.warn("Token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                HttpServletResponse httpServletResponse = context.getResponse();
                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                httpServletResponse.getWriter().write("Token is empty啊啊啊");
            } catch (IOException e) {
            }
        } else {
            log.info("OK");
        }
        return null;
    }
}
