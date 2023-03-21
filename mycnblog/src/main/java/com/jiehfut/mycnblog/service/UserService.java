package com.jiehfut.mycnblog.service;


import com.jiehfut.mycnblog.mapper.UserMapper;
import com.jiehfut.mycnblog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int register(String username, String password) {
        return userMapper.register(username, password);
    }

    public UserInfo login(String username, String password) {
        return userMapper.login(username, password);
    }

    public UserInfo getMyInfo(int id) {
        return userMapper.getMyInfo(id);
    }
}
