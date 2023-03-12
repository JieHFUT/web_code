package com.jiehfut.springtransacyion.controller;


import com.jiehfut.springtransacyion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    @Transactional
    public int add(String username, String password) {
        if (!StringUtils.hasLength(username) && !StringUtils.hasLength(password)){
            return 0;
        }
        int result = userService.add(username, password);
        System.out.println("执行了UserController的add方法！");
        // int testTransactional = 10 / 0;
        return result;
    }
}
