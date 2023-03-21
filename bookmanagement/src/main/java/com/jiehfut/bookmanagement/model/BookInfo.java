package com.jiehfut.bookmanagement.model;


import lombok.Data;

@Data
public class BookInfo {

    private int id;
    private String title;
    private String author;
    private String price;
    private String press;
    private int edition;
}
