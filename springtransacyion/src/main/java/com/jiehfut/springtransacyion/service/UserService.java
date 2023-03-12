package com.jiehfut.springtransacyion.service;


import com.jiehfut.springtransacyion.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int add(String username, String password) {
        return userMapper.add(username, password);
    }
}
