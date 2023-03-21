package com.jiehfut.bookmanagement.service;


import com.jiehfut.bookmanagement.mapper.BookMapper;
import com.jiehfut.bookmanagement.model.BookInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<BookInfo> getBookList(){
        return bookMapper.getBookList();
    }

    public List<BookInfo> getBookByTitle(String title){
        return bookMapper.getBookByTitle(title);
    }

    public List<BookInfo> getBookByAuthor(String author){
        return bookMapper.getBookByAuthor(author);
    }

    public List<BookInfo> getBookByPress(String press){
        return bookMapper.getBookByPress(press);
    }

    public BookInfo getBookInfoById(int id) { return bookMapper.getBookInfoById(id); };

    public int update(BookInfo bookInfo){
        return bookMapper.update(bookInfo);
    }


    public int add(BookInfo bookInfo){
        return bookMapper.add(bookInfo);
    }

    public int delBookById(int id){
        return bookMapper.delBookById(id);
    }

}
