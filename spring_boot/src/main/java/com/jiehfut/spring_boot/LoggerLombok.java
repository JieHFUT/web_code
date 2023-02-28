package com.jiehfut.spring_boot;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoggerLombok {

    @RequestMapping("/sayLombok")
    public String sayLombok() {
        log.error("this is lombok error. ");
        log.warn("this is lombok warn. ");
        return "LoggerLombom";
    }

}
