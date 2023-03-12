package com.jiehfut.springlogin.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/user/login") // 排除不拦截的 url
                .excludePathPatterns("/favicon.ico")
//                .excludePathPatterns("/**/*.html")
//                .excludePathPatterns("/**/*.js")
//                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/user/reg"); // 排除不拦截的 url
    }

}
