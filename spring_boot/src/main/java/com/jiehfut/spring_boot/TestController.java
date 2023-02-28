package com.jiehfut.spring_boot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    // 获取用户自己配置的信息

    @Value("${mykey.key}")
    private String mykey;

    @Value("${server.port}")
    private Integer port;


    @RequestMapping("/sayHi")
    public String sayHi() {
        return "Hi. " + mykey + "| port:  " + port;
    }
}