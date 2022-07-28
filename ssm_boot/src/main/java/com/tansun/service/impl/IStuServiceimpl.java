package com.tansun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tansun.dao.StudentDao;
import com.tansun.pojo.Student;
import com.tansun.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:42
 */
@Service
public class IStuServiceimpl extends ServiceImpl<StudentDao, Student> implements IStuService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public IPage<Student> getPage(Integer current, Integer Size) {
        Page<Student> page = new Page<>(current, Size);
        studentDao.selectPage(page,null);
        return page;
    }
}
