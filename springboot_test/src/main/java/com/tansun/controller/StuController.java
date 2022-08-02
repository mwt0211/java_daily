package com.tansun.controller;

import com.tansun.Service.IStuServiceDao;
import com.tansun.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 15:16
 */
@RestController
@RequestMapping("/Stu")
public class StuController {
    @Autowired
    private IStuServiceDao iStuServiceDao;
    @GetMapping
    public List<Student> getAll(){
        List<Student> list = iStuServiceDao.list();
        return list;
    }
}
