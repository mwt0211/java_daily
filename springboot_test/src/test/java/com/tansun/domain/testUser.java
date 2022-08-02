package com.tansun.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/1 15:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "testcase.testuser")
public class testUser {
    private int id;
    private String name;
    private String uuid;
    private long publishTime;

}
