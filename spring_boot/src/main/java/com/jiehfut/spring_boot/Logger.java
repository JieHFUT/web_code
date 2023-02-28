package com.jiehfut.spring_boot;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logger {


    @Value("${server.port}")
    private String port;



    // 1. 得到日志对象
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    // 2. 使用日志对象提供的方法，输出自定义的日志信息

    @RequestMapping("/sayLog")
    public String sayLog() {
        logger.info("this is the first log. ");
        return port;
    }
}
