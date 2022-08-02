package com.tansun.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tansun.Service.IStuServiceDao;
import com.tansun.dao.StudentDao;
import com.tansun.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 15:12
 */
@Service
public class IStuService extends ServiceImpl<StudentDao, Student> implements IStuServiceDao {
    @Autowired
    private StudentDao studentDao;
}
