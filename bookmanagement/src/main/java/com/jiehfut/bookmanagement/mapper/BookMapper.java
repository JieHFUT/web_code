package com.jiehfut.bookmanagement.mapper;

import com.jiehfut.bookmanagement.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    // 在加载登入页面的时候返回数据库中的书籍信息
    public List<BookInfo> getBookList();

    // 根据书籍的名称来查询某本书籍的全部信息
    public List<BookInfo> getBookByTitle(@Param("title") String title);
    public List<BookInfo> getBookByAuthor(@Param("author") String author);
    public List<BookInfo> getBookByPress(@Param("press") String press);

    public BookInfo getBookInfoById(@Param("id") int id);

    // 根据书籍的名称来修改某本书籍的信息
    public int update(@Param("bookInfo") BookInfo bookInfo);

    // 在数据库中添加一条记录
    public int add(@Param("bookInfo") BookInfo bookInfo);

    // 根据 bookInfo 中的 id 来删除相应的书籍信息
    public int delBookById(@Param("id") int id);
}
