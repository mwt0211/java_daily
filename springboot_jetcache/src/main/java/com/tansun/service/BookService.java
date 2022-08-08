package com.tansun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tansun.pojo.Book;

import java.util.List;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/3 15:11
 */

public interface BookService extends IService<Book> {
    public Book getById(Integer id);
    public Boolean Save(Book book);
    public Boolean Updated(Book book);
    public Boolean delete(Integer id);
    public List<Book>getAll();

}
