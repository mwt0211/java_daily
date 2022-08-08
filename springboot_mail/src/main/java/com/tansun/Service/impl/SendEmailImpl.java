package com.tansun.Service.impl;

import com.tansun.Service.SendEmailService;
import com.tansun.Util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/8 16:42
 */
@Service
@Component
public class SendEmailImpl implements SendEmailService {
    @Autowired
    private CodeUtil codeUtil;
    @Autowired
    private JavaMailSender javaMailSender;
    private String Sender="2216236697@qq.com";//发件人
    private String Receiver="mwt17537630237@163.com";//收件人
    private String Topic="邮件激活码";//主题
    private String Content="尊敬的QQ用户你好,请输入以下验证码来激活你的账户:";//正文
    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void SendEmail() {
        Random random = new Random();
        int i = random.nextInt(200);
        String EmailCode=String.valueOf(i);
        String code = codeUtil.GenernateCode(EmailCode);
        SimpleMailMessage Message=new SimpleMailMessage();
        Message.setText(Content+code);
        Message.setFrom(Sender);
        Message.setTo(Receiver);
        Message.setSubject(Topic);
        javaMailSender.send(Message);
    }
}
