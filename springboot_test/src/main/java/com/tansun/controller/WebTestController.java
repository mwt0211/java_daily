package com.tansun.controller;

import com.tansun.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 9:46
 */
@RestController
@RequestMapping("/test")
public class WebTestController {
    @GetMapping
    public String getById(){
        System.out.println("11111");
        return "模拟Web测试";
    }
    @GetMapping("/Stu")
    public Student getById1(){
        System.out.println("11111");
        Student student = Student.builder().age(18).name("张三")
                .address("河南").sex("男").math(99).english(100).id(222).build();
        return student;
    }
}
