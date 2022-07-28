package com.tansun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tansun.dao.StudentDao;
import com.tansun.pojo.Student;
import com.tansun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 9:51
 */
@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
   private StudentDao studentDao;
    @Override
    public boolean deleteById(Integer id) {

        return studentDao.deleteById(id)>0;
    }

    @Override
    public boolean updateById(Student student) {
        // int updateById(@Param("et") T entity);
        return studentDao.updateById(student)>0;
    }

    @Override
    public boolean save(Student student) {
        //int insert(T entity);
        return studentDao.insert(student)>0;
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<Student> getAll() {

        return studentDao.selectList(null);
    }

    @Override
    public IPage<Student> getPage(Integer current, Integer size) {
        Page<Student> page = new Page<>(current,size);
        return studentDao.selectPage(page,null);
    }
}
