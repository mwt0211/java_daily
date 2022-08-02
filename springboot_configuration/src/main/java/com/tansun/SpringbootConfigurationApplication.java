package com.tansun;

import com.tansun.config.servletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(servletConfig.class)
public class SpringbootConfigurationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootConfigurationApplication.class, args);
        servletConfig config = context.getBean(servletConfig.class);
        System.out.println("config = " + config);
    }

}
