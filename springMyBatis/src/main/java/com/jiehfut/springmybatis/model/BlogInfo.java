package com.jiehfut.springmybatis.model;


import lombok.Data;

import java.util.Date;


@Data
public class BlogInfo {

    // 博客ID
    private int blogId;

    // 文章标题
    private String title;

    // 文章内容
    private String content;

    // 用户ID
    private int userId;

    // 提交时间
    private Date postTime;
}
