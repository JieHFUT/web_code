package com.jiehfut.mycnblog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AplicationConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    // 不拦截的集合
    // List<String> excludes = Arrays.asList();
    List<String> excludes = new ArrayList<String>() {{
        add("/**/*.html");
        add("/js/**");
        add("/editor.md/**");
        add("/css/**");
        add("/img/**"); // 放行 static/img 下的所有文件
        add("/user/login"); // 放行登录接口
        add("/user/reg"); // 放行注册接口
        add("/art/detail"); // 放行文章详情接口
        add("/art/list"); // 放行文章分页列表接口
        add("/art/totalpage"); // 放行文章分页总页数接口
    }};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration registration =
                registry.addInterceptor(loginInterceptor);
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(excludes);
    }
}
