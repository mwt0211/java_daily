package com.tansun;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import com.tansun.Service.IStuServiceDao;
import com.tansun.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.transaction.annotation.Transactional;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 9:36
 */
//Web环境模拟测试
//webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT以默认的端口启动web环境
//webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT:随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc//开启mvc模拟调用
@Transactional
@Rollback(false)//默认为true
public class WebTest {
    @Test
    void webTestStatus(@Autowired MockMvc mvc) {
        //创建虚拟请求,访问/test
        MockHttpServletRequestBuilder builld = MockMvcRequestBuilders.get("/test");
        try {
            ResultActions perform = mvc.perform(builld);
            //设置预期值
            StatusResultMatchers status = MockMvcResultMatchers.status();
            ResultMatcher ok = status.isOk();
            //调用真实值,预期望值进行匹配
            ResultActions resultActions = perform.andExpect(ok);
            System.out.println("resultActions = " + resultActions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestBodyResult(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/test");
        ResultActions perform = mvc.perform(builder);
        //设置预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("模拟Web测试");
        //调用真实值
        perform.andExpect(result);
    }

    @Test
    void TestJsonBodyResult(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/test/Stu");
        ResultActions perform = mvc.perform(builder);
        //设置预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\n" +
                "    \"id\": 22,\n" +
                "    \"name\": \"张三\",\n" +
                "    \"age\": 18,\n" +
                "    \"sex\": \"男\",\n" +
                "    \"address\": \"河南\",\n" +
                "    \"math\": 99,\n" +
                "    \"english\": 100\n" +
                "}");
        //调用真实值
        perform.andExpect(json);


    }

    @Test
    void TestContentType(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/test/Stu");
        ResultActions perform = mvc.perform(builder);
        //设置预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher resultMatcher = header.string("Content-Type", "application/json");

        //调用真实值
        perform.andExpect(resultMatcher);
    }
    @Test
    void TestGetById1(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/test/Stu");
        ResultActions perform = mvc.perform(builder);
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        perform.andExpect(ok);
        ResultMatcher ContentType = MockMvcResultMatchers.header().string("Content-Type", "application/json");
        perform.andExpect(ContentType);
        ResultMatcher jsonResult = MockMvcResultMatchers.content().json("{\n" +
                "    \"id\": 222,\n" +
                "    \"name\": \"张三\",\n" +
                "    \"age\": 18,\n" +
                "    \"sex\": \"男\",\n" +
                "    \"address\": \"河南\",\n" +
                "    \"math\": 99,\n" +
                "    \"english\": 100\n" +
                "}");
        perform.andExpect(jsonResult);
    }
    @Autowired
    private IStuServiceDao iStuServiceDao;
    @Test
    void testInsertStu(){
        Student student = Student.builder().age(18).name("李四11222")
                .address("河南").sex("男").math(99).english(100).build();
        iStuServiceDao.save(student);

    }
}
