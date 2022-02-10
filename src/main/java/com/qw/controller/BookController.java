package com.qw.controller;

import com.qw.pojo.Books;
import com.qw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    // controller层调用service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    // 查询全部的书籍，并且返回到一个书籍展示页面上
    @RequestMapping("/allBook")
    public String list(Model model){
        // 业务逻辑
        List<Books> books = bookService.queryAllBook();
        // 装填数据
        model.addAttribute("list",books);
        // 返回视图
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    // 添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        // 打印前端传回来的数据
        System.out.println("addBooks=>"+books);
        // 业务层调用service层
        int index = bookService.addBook(books);
        // 回到首页进行重定向到请求
        return "redirect:/book/allBook";
    }

    // 跳转到修改页面,前端传回id信息，业务查询到id对应的书籍数据后返回给前端
    @RequestMapping("/toUpdatePaper")
    public  String toUpdatePaper(int id, Model model){
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }

    // 修改书籍信息
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        // 获取前端接收的数据
        System.out.println("book:"+books);
        // 调用业务层修改数据
        int index = bookService.updateBook(books);
        if(index > 0){
            System.out.println("修改成功！");
        }
        // 返回视图
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deletdBook(id);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @RequestMapping("/queryBookName")
    public String queryBook(String queryBookName, Model model){
        List<Books> booksList = new ArrayList<>();
        Books books = bookService.queryBookByName(queryBookName);
        // 没查到书籍的情况
        if (books == null){
            booksList = bookService.queryAllBook();
            model.addAttribute("err","未查到！");
        }else {
            booksList.add(books);
        }
        model.addAttribute("list",booksList);
        return "allBook";
    }

}
