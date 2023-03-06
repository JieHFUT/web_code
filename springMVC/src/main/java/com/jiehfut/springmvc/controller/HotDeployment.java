package com.jiehfut.springmvc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotDeployment {

    @RequestMapping("/hotdeployment")
    public String TsetHotDeployment(String hot) {
        return "hot deplyment ok. ";
    }

}
