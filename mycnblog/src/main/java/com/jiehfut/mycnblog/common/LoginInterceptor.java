package com.jiehfut.mycnblog.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 去session中得到用户信息(如果在session中得到了用户的userinfo对象，说明用户已经登陆了，否则就没有登录)
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            // 当前用户已经进行了登录
            return true;
        }
        // 401:没有登录权限
        response.setStatus(401);
        return false;
    }
}
