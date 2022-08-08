package com.tansun.Controller;

import com.tansun.pojo.Book;
import com.tansun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping("/update")
    public Boolean Update(@RequestBody Book book){
        Boolean updated = bookService.Updated(book);
        return updated;
    }
    @DeleteMapping("/{id}")
    public Boolean Delete( @PathVariable  Integer id ){
        Boolean delete = bookService.delete(id);
        return delete;
    }
    @PutMapping("/save")
    public Boolean Insert( @RequestBody Book book ){
        Boolean save = bookService.Save(book);
        return save;
    }

}
