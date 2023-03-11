package com.jiehfut.springmybatis.mapper;

import com.jiehfut.springmybatis.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;


@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getAll() {
        List<UserInfo> userInfoList = userMapper.getAll();
        for (UserInfo user : userInfoList) {
            System.out.println(user.toString());
        }
    }
}




