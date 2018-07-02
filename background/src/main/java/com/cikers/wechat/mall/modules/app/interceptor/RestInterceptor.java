package com.cikers.wechat.mall.modules.app.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 权限(Token)验证
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:38
 */
@Component
@Configuration
@Slf4j
public class RestInterceptor extends HandlerInterceptorAdapter {
    @Value("${cikers.server.host}")
//    private String host = "http://newstack.cikers.com:10422/mall/v1.0";
    private String host;
    @Autowired
    private RestTemplate restTemplate;

    public RestInterceptor() {
        log.info("...代理拦截器初始化...");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("req:" + requestURI);
        String[] urls = requestURI.split("mall");
        String redirect = host + urls[1];
        log.info("sendRedirect:" + redirect);
        if ("GET".equals(request.getMethod())) {
            response.sendRedirect(redirect);
        } else if ("POST".equals(request.getMethod())) {
            Map<String, String> body = new HashMap<>();
            Enumeration<String> keys = request.getParameterNames();
            if (!keys.hasMoreElements()) {
                String key = keys.nextElement();
                String value = request.getParameter(key);
                body.put(key, value);
            }
            Object respBody = restTemplate.postForObject(redirect, body, Object.class);
            response.getWriter().print(respBody);

        }
        return true;
    }
}