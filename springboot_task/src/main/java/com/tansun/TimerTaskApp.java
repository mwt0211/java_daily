package com.tansun;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/8 15:17
 */
public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {

                Random random2 = new Random();
                int i = random2.nextInt(100);

                Random random = new Random();
                int i1 = random.nextInt(200);

                System.out.println("生成的两个随机数之和为: " + (i+i1));

            }
        };
        timer.schedule(task,0,3000);
    }
}
