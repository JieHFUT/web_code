package com.jiehfut.springtransacyion.controller;


import com.jiehfut.springtransacyion.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/delById")
    public int delById(Integer blogId) {
        System.out.println("执行了BlogController的delById方法");
        return blogService.delById(blogId);
    }
}
