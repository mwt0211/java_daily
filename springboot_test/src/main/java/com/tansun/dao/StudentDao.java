package com.tansun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tansun.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 15:08
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
