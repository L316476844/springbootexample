package org.jon.lv.mail;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @Package org.jon.lv.mail.EmailService
 * @Description: EmailService
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/16 11:02
 * version V1.0.0
 */
public class EmailService extends SpringbootexampleApplicationTests {

    @Autowired
    private JavaMailSender mailSender;
    /**
     * 修改application.properties的用户，才能发送。
     */
    @Test
    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("316476844@qq.com");//发送者.
        message.setTo("lvbin@oriental-finance.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.

        mailSender.send(message);//发送邮件
    }
}
