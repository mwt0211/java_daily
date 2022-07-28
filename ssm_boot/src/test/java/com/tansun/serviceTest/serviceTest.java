package com.tansun.serviceTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tansun.pojo.Student;
import com.tansun.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * program: ssm_boot
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/28 10:15
 */
@SpringBootTest
public class serviceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void testgetById() {
        studentService.getById(2);
    }

    @Test
    void testgetAll() {
        studentService.getAll();
    }

    @Test
    void testInsert() {
        Student student = Student.builder()
                .name("李四").english(88).math(99).age(28)
                .address("新乡").sex("男").build();
        studentService.save(student);
    }
    @Test
    void testgetPage(){
        IPage<Student> page = studentService.getPage(3, 5);

    }
    @Test
    void testUpdate(){
        Student student = Student.builder().address("新乡").name("马化腾").age(18).id(11).build();
        studentService.updateById(student);
    }
}
