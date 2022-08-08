package com.tansun.quzrtz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Random;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/8 15:35
 */
public class quartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Random random = new Random();
        int i = random.nextInt(200);
        int i1 = random.nextInt(100);
        System.out.println("quartzJob   两个随机数的乘积为:" + (i*i1));
    }
}
