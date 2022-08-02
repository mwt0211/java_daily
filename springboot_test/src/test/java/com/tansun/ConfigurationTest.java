package com.tansun;

import com.tansun.config.ConfigrationBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 9:20
 */
@SpringBootTest
@Import(ConfigrationBean.class)
public class ConfigurationTest {
    @Autowired
    private String msg;
    @Test
    void configureTest(){
        System.out.println("msg = " + msg);
    }
}
