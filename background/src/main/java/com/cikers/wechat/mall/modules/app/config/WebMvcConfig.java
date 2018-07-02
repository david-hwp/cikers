package com.cikers.wechat.mall.modules.app.config;

import com.cikers.wechat.mall.modules.app.interceptor.AuthorizationInterceptor;
import com.cikers.wechat.mall.modules.app.interceptor.RestInterceptor;
import com.cikers.wechat.mall.modules.app.resolver.LoginUserHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * MVC配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-20 22:30
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    //    @Autowired
//    private RestInterceptor restInterceptor;
    @Bean
    RestInterceptor restInterceptor() {
        return new RestInterceptor();
    }

    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/app/**");
        registry.addInterceptor(restInterceptor()).addPathPatterns("/mall/**").excludePathPatterns("/mall/user/login");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}