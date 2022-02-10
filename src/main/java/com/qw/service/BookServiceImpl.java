package com.qw.service;

import com.qw.dao.BookMapper;
import com.qw.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;


public class BookServiceImpl implements BookService{

    // 业务层调用dao层，所以这里需要组合dao层
    private BookMapper bookMapper;

    // 设置set方法，这样可以让spring进行托管
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deletdBook(int id) {
        return bookMapper.deletdBook(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
