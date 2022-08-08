package com.tansun.quzrtz;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Random;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/8 16:14
 */
@Component
public class DemoJobBean {
    @Scheduled(cron = "0/3 * * * * ?")
    public void Cal(){
        Random random = new Random();
        int i = random.nextInt(200);
        int i1 = random.nextInt(100);
        System.out.println(Thread.currentThread().getName()+"两个随机数的和为: " + (i1+i));
    }
}
