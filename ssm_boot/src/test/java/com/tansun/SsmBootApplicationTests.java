package com.tansun;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tansun.dao.StudentDao;
import com.tansun.pojo.Student;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmBootApplicationTests {
    @Autowired
    private StudentDao studentDao;

    @Test
        //查询全部
    void getAll() {
        System.out.println("studao.selectList(null) = " + studentDao.selectList(null));
    }

    @Test
        //根据Id查询
    void tsetgetById() {
        System.out.println("studentDao.selectById(5) = " + studentDao.selectById(5));
    }

    @Test
        //增加记录
    void testInsert() {
        Student student = Student.builder().sex("男")
                .address("河南").age(18).math(99).english(88).name("李四")
                .build();
        System.out.println("studentDao.insert(student) = " + studentDao.insert(student));

    }

    @Test
//分页查询
    void testPage() {
        Page<Student> page = new Page<>(1, 1);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "张三");
        System.out.println("studentDao.selectPage(page,wrapper) = " + studentDao.selectPage(page, wrapper));
    }
@Test
//按条件查询
//英语成绩高于80且数学成绩高于80,且姓名为马*****
    void testByContional(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("english",80)
                .gt("math",80)
                .likeRight("name","马");
        studentDao.selectList(queryWrapper);
    }
    @Test
    //按条件查询2
    //利用LambdaQueryWrapper避免collum出现字段拼写错误的情况
    void testByContional2(){
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        String name="马";
        wrapper.gt(Student::getEnglish,80)
                .gt(Student::getMath,80).
                likeRight(Strings.isNotEmpty(name),Student::getName,name);
        studentDao.selectList(wrapper);
        //SELECT id,name,age,sex,address,math,english FROM student WHERE (english > ? AND math > ? AND name LIKE ?)
        /*<==    Columns: id, name, age, sex, address, math, english
<==        Row: 2, 马化腾, 45, 女, 深圳, 98, 87
<==        Row: 7, 马德, 22, 女, 香港, 99, 99*/
    }
    //按条件查询3
    @Test
    void testByContional3() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        String name = null;
        wrapper.gt(Student::getEnglish, 80)
                .gt(Student::getMath, 80).
                likeRight(Strings.isNotEmpty(name), Student::getName, name);
        studentDao.selectList(wrapper);
        //SELECT id,name,age,sex,address,math,english FROM student WHERE (english > ? AND math > ?)
    }
}
