package com.jiehfut.mycnblog.controller;


import com.jiehfut.mycnblog.common.AjaxResult;
import com.jiehfut.mycnblog.common.Constant;
import com.jiehfut.mycnblog.model.UserInfo;
import com.jiehfut.mycnblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String Test() {
        return "hello. ";
    }

    @RequestMapping("/reg")
    public Object register(String username, String password) {
        // 1. 进行用户名和密码的非空验证
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return AjaxResult.fail(-1, "非法的参数请求！");
        }
        int result = userService.register(username, password);
        if (result == 1) {
            return AjaxResult.Success("注册成功！", 1);
        } else {
            return AjaxResult.fail(-1, "注册失败，数据库添加出错！");
        }
    }

    @RequestMapping("/login")
    public int loign(HttpServletRequest request, String username, String password) {
        // 1. 进行非空校验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return 0;
        }
        // 2. 进行数据库的添加操作
        UserInfo userInfo = userService.login(username, password);
        if (userInfo == null || userInfo.getId() <= 0) {
            return -1;
        }
        // 登录成功，将userInfo这个对象保存到session中
        HttpSession session = request.getSession();
        session.setAttribute(Constant.SESSION_USERINFO_KEY, userInfo);
        return 1;
    }


    @RequestMapping("/loginout")
    public boolean loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null &&
                session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            // 正常 session 中当前登录的用户
            session.removeAttribute(Constant.SESSION_USERINFO_KEY);
        }
        return true;
    }

    @RequestMapping("/myinfo")
    public UserInfo myInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            // 返回用户信息
            UserInfo userInfo = userService.getMyInfo(((UserInfo) session.getAttribute(Constant.SESSION_USERINFO_KEY)).getId());
            return userInfo;
        }
        return null;
    }
}