package com.jiehfut.springlogin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/login")
    public boolean login(HttpServletRequest request, String username, String password) {
        // 1. 判断用户名和密码输入非空
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)){
            // 2. 验证用户的用户名和密码是否正确
            if ("admin".equals(username) && "admin".equals(password)) {
                // 登陆成功
                HttpSession session = request.getSession();
                session.setAttribute("userinfo", "admin");
                return true;
            }else {
                // 用户名或者密码输入错误
                return false;
            }
        }
        return false;
    }



    @RequestMapping("/getinfo")
    public String getInfo() {
        log.debug("执行了 getinfo 方法");
        return "执行了 getinfo 方法";
    }



    // 注册
    @RequestMapping("/reg")
    public String reg() {
        log.debug("执行了 reg 方法");
        return "执行了 reg 方法";
    }

}
