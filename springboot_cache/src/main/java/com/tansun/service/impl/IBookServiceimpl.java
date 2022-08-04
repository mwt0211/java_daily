package com.tansun.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tansun.dao.BookDao;
import com.tansun.pojo.Book;
import com.tansun.service.BookService;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/3 15:12
 */
@Service
public class IBookServiceimpl extends ServiceImpl<BookDao, Book> implements BookService {
    @Autowired
    private BookDao bookdao;

   private  HashMap<Integer,Book> cache=new HashMap<Integer,Book>();

    @Override
    public Book getById(Integer id) {
        //模拟从缓存中拿数据
        Book book = cache.get(id);
        if(book == null){
          Book  querybook= bookdao.selectById(id);
            cache.put(id,querybook);
            return querybook;
        }
        return cache.get(id);

    }

    @Override
    public Boolean Save(Book book) {
        return bookdao.insert(book)>0;
    }

    @Override
    public Boolean Updated(Book book) {
        return bookdao.updateById(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookdao.deleteById(id)>0;
    }

    @Override
    public List<Book> getAll() {
        return bookdao.selectList(null);
    }
}
