package com.jiehfut.spring_boot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerTest {


    @Value("${server.port}")
    private String port;



    // 1. 得到日志对象
    public static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    // 2. 使用日志对象提供的方法，输出自定义的日志信息
    @RequestMapping("/sayLog")
    public String sayLog() {
        logger.info("this is the first log. ");

        // 日志的级别
        // 1.微量，少许的意思，级别最低；
        logger.trace("this is a trace. ");
        // 2.需要调试时候的关键信息打印；
        logger.debug("this is a debug. ");
        // 3.普通的打印信息；
        logger.info("this is a info. ");
        // 4.警告，不影响使⽤，但需要注意的问题；
        logger.warn("this is a warn. ");
        // 5.错误信息，级别较⾼的错误⽇志信息；
        logger.error("this is a error. ");
        // 6.致命的，因为代码异常导致程序退出执⾏的事件。

        return port;
    }



}

