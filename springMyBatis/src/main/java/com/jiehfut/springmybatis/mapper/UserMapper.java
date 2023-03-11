package com.jiehfut.springmybatis.mapper;


import com.jiehfut.springmybatis.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 查询所有的用户信息
    public List<UserInfo> getAll();


}
