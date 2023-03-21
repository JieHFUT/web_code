package com.jiehfut.mycnblog.mapper;

import com.jiehfut.mycnblog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 1. 注册方法
    public int register(@Param("username") String username,
                        @Param("password") String password);

    // 2. 登陆方法
    public UserInfo login(@Param("username") String username,
                          @Param("password") String password);

    public UserInfo getMyInfo(@Param("id") int id);
}
