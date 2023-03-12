package com.jiehfut.springtransacyion.mapper;


import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public int add(@Param("username") String username,
                    @Param("password") String password);


}
