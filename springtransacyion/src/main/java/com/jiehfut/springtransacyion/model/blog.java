package com.jiehfut.springtransacyion.model;


import lombok.Data;

import java.util.Date;

@Data
public class blog {

    private int userId;
    private int blogId;
    private String title;
    private String content;
    private Date postTime;


}
