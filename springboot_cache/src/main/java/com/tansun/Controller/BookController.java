package com.tansun.Controller;

import com.tansun.pojo.Book;
import com.tansun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/4 12:09
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/all")
    public List<Book>getAll(){
        List<Book> list = bookService.list();
        System.out.println("list = " + list);
        return list;
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Integer id){
        Book book = bookService.getById(id);
        return book;
    }

}
