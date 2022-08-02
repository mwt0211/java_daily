package com.tansun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 15:06
 */
//@Configuration
public class MybatisPlusPageConfig {
    @Bean
    public String msg(){
        return "SpringBoot configration  Bean msg ";
    }
}
