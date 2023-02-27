package com.jiehfut.spring_boot;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/sayHi")
    public String sayHi() {
        return "Hi. ";
    }


}
