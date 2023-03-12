package com.jiehfut.springtransacyion.service;


import com.jiehfut.springtransacyion.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    public int delById(Integer blogId) {
        return blogMapper.delById(blogId);
    }
}
