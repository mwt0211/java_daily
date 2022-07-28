package com.tansun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tansun.pojo.Student;

import java.util.List;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 9:48
 */
public interface StudentService {
    public boolean deleteById(Integer id);
    public boolean updateById(Student student);
    public boolean save(Student student);
    public Student getById(Integer id);
    public List<Student> getAll();
    public IPage<Student>getPage(Integer current,Integer size);
}
