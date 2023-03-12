package com.jiehfut.springlogin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断登陆业务
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            return true;
        }
        log.debug("当前用户没有访问权限！");
        response.setStatus(401);
        return false;
    }
}
