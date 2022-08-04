package com.tansun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tansun.dao.bookdao;
import com.tansun.pojo.Book;
import com.tansun.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/3 15:12
 */
@Service
public class IBookServiceimpl extends ServiceImpl<bookdao, Book> implements bookService {
    @Autowired
    private bookdao bookdao;
}
