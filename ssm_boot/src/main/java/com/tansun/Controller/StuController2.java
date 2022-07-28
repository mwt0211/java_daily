package com.tansun.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tansun.pojo.Student;
import com.tansun.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:12
 */
//@RestController
//@RequestMapping("/Stu")
public class StuController2 {
    @Autowired
    private IStuService iStuService;

    //查询所有
    @GetMapping("/all")
    public List<Student> getAll() {
        List<Student> list = iStuService.list();
        return list;
    }

    //根据ID查询
    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        Student student = iStuService.getById(id);
        return student;
    }

    //添加记录
    @PostMapping("/insert")
    public boolean insert(@RequestBody Student student) {
        boolean save = iStuService.save(student);
        return save;
    }

    //根据ID删除
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean b = iStuService.removeById(id);
        return b;
    }

    //分页查询
    @GetMapping("/page/{currentPage}/{Size}")
    public IPage<Student> getPage(@PathVariable Integer currentPage, @PathVariable Integer Size) {
        IPage<Student> page = iStuService.getPage(currentPage, Size);
        return page;
    }
}
