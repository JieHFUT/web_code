package com.jiehfut.bookmanagement.controller;


import com.jiehfut.bookmanagement.model.BookInfo;
import com.jiehfut.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/2020210626")
public class BookController {

    @Autowired
    private BookService bookService;

    // 登入页面加载数据库中的书籍信息
    @RequestMapping("/booklist")
    public List<BookInfo> bookList(){
        return bookService.getBookList();
    }

    // 在重新编辑某本书的内容之后，提交修改数据
    @RequestMapping("/update")
    public int update(BookInfo bookInfo){
        return bookService.update(bookInfo);
    }

    @RequestMapping("/add")
    public int add(BookInfo bookInfo){

        int ret = bookService.add(bookInfo);
        if (ret != 0){
            return ret;
        }else {
            // 约定返回0代表添加到数据库添加失败
            return 0;
        }
    }

    @RequestMapping("/del")
    public int del(int id){
        return bookService.delBookById(id);
    }

    @RequestMapping("/getbookinfobyid")
    public BookInfo getBookInfoById(int id){ return bookService.getBookInfoById(id); }

    @RequestMapping("/query")
    public List<BookInfo> queryBookBySelected(String selected, String queryInfo){
        if (selected.equals("书籍名称")) {
            List<BookInfo> bookInfoList = bookService.getBookByTitle(queryInfo);
            if (bookInfoList == null){
                return null;
            }else {
                return bookInfoList;
            }
        }else {
            if (selected.equals("作者姓名")) {
                List<BookInfo> bookInfoList = bookService.getBookByAuthor(queryInfo);
                if (bookInfoList == null){
                    return null;
                }else {
                    return bookInfoList;
                }
            }else {
                // 选择项是出版社
                List<BookInfo> bookInfoList = bookService.getBookByPress(queryInfo);
                if (bookInfoList == null){
                    return null;
                }else {
                    return bookInfoList;
                }
            }
        }
    }
}
