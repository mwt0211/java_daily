package com.tansun.Service.impl;

import com.tansun.Service.SendEmailService;
import com.tansun.Util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
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
    private String Content="尊敬的QQ用户你好,请<a href = 'https://wwww.baidu.com'>点击以下链接</a>来输入以下验证码保证激活你的账户:";//正文
    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void SendSimpleEmail() {
        Random random = new Random();
        int i = random.nextInt(200);
        String EmailCode = String.valueOf(i);
        String code = codeUtil.GenernateCode(EmailCode);
        SimpleMailMessage Message = new SimpleMailMessage();
        Message.setText(Content + code);
        Message.setFrom(Sender);
        Message.setTo(Receiver);
        Message.setSubject(Topic);
        javaMailSender.send(Message);


    }
    @Override
    public void SendComplexEmail() {
        MimeMessage Message=javaMailSender.createMimeMessage();
        try {
        MimeMessageHelper helper = new MimeMessageHelper(Message,true);
        Random random = new Random();
        int i = random.nextInt(200);
        String EmailCode = String.valueOf(i);
        String code = codeUtil.GenernateCode(EmailCode);
        File imgFile = new File("C:\\Users\\ada\\Pictures\\Saved Pictures\\44.png");
        File textFile = new File("C:\\Users\\ada\\Documents\\任务调度框架.md");
        File jarFile = new File("C:\\Users\\ada\\Documents\\test.zip");

            helper.setText(Content + code,true);
            helper.setFrom(Sender+"(吴彦祖)");
            helper.setTo(Receiver);
            helper.addAttachment("风景图",imgFile);
            helper.addAttachment("markDown",textFile);
            helper.addAttachment("jar包",jarFile);
            helper.setSubject(Topic);
            javaMailSender.send(Message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
