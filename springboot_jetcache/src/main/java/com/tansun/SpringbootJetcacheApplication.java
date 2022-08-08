package com.tansun;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启jetcache的主开关
@EnableCreateCacheAnnotation
public class SpringbootJetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJetcacheApplication.class, args);
    }

}
