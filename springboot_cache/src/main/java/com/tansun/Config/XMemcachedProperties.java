package com.tansun.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/5 15:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "xmemcache")
public class XMemcachedProperties {
    private String host;
    private Integer poolSize;
    private long TimeOut;
}
