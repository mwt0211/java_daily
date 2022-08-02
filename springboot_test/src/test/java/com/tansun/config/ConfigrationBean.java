package com.tansun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 9:18
 */
@Configuration
public class ConfigrationBean {
    @Bean
    public String msg(){
        return "SpringBoot configration  Bean msg ";
    }
}
