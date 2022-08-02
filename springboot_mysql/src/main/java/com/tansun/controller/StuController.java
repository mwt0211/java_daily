package com.tansun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tansun.pojo.Student;
import com.tansun.service.IStuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:12
 */
@RestController
@RequestMapping("/Stu")
@Slf4j
public class StuController {
    @Autowired
    private IStuService iStuService;
    //开启日志追加
 // private static final Logger log=  LoggerFactory.getLogger(StuController.class);
    //查询所有
@GetMapping("/all")
public List<Student> getAll(){
    List<Student> list = iStuService.list();
    return list;
}





}
