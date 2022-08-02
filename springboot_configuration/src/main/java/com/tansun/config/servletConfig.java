package com.tansun.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/7/29 15:40
 */
@Data
//@Component
@ConfigurationProperties(prefix = "servers")
//开启校验功能
@Validated
public class servletConfig {
    private String ipAddress;
    //注明校验规则
    @Max(value = 9999,message = "端口号最大值不能超过9999")
    @Min(value = 202,message = "端口号最小值不能小于202")
    private int port;
    private long timeout;
    @DurationUnit(ChronoUnit.SECONDS)//自定义超时时间
    private Duration serverTimeOut;
    @DataSizeUnit(DataUnit.MEGABYTES)//配置内存空间大小,单位为M
    private DataSize dataSize;
}
