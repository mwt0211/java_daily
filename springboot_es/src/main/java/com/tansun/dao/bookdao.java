package com.tansun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tansun.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/3 15:09
 */
@Mapper
public interface bookdao extends BaseMapper<Book> {
}
