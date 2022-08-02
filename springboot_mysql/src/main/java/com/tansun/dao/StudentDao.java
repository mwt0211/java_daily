package com.tansun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tansun.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/27 15:44
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

}
