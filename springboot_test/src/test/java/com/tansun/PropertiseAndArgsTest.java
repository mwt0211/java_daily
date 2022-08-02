package com.tansun;

import com.tansun.domain.testUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
//properties:临时属性覆盖值,能够覆盖配置文件中的属性值
//@SpringBootTest(properties = {"test.pro=test1111"})
//args:属性能够为当前测试用例添加临时的命令行参数
//@SpringBootTest(args = {"--test.pro=test2222"})
@SpringBootTest
class PropertiseAndArgsTest {
@Value("${test.pro}")
private String testpro;
@Autowired
private testUser testUser;
    @Test
    void testPropertise() {
        System.out.println("testpro = " + testpro);
    }
    @Test
    void testRandom(){
        System.out.println("testUser = " + testUser);
    }

}
