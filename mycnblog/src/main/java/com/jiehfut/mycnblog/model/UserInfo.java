package com.jiehfut.mycnblog.model;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private int state;
    private int articlenumber;
}