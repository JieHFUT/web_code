package com.jiehfut.springtransacyion.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogMapper {

    public int delById(@Param("blogId") Integer blogId);

}
