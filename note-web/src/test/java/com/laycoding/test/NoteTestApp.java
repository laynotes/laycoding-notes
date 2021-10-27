package com.laycoding.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author laycoding
 * @date 2021/10/27
 **/
@SpringBootTest
public class NoteTestApp {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void test(){
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("邮件主题");
        message.setText("邮件内容");
        message.setTo("1940758238@qq.com");
        message.setFrom("laycoding@163.com");
        javaMailSender.send(message);
       // return "简单邮件发送成功！"
    }
}
