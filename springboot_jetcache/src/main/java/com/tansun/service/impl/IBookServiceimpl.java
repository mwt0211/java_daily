package com.tansun.service.impl;


import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tansun.dao.BookDao;
import com.tansun.pojo.Book;
import com.tansun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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


    //以ID作为缓存的key
    @Override
    @Cached(name = "book_", expire = 15, timeUnit = TimeUnit.SECONDS, key = "#id")
    //保证缓存和系统的数据刷新一致
//    @CacheRefresh(refresh = 10, timeUnit = TimeUnit.SECONDS)
    public Book getById(Integer id) {
        return bookdao.selectById(id);
    }

    @Override
    public Boolean Save(Book book) {
        return bookdao.insert(book) > 0;
    }

    @Override
    //更新同步到缓存中
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public Boolean Updated(Book book) {
        return bookdao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")//删除同步到缓存中
    public Boolean delete(Integer id) {
        return bookdao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookdao.selectList(null);
    }
}
