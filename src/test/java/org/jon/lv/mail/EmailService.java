package org.jon.lv.mail;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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

    /**
     * 测试发送附件.(这里发送图片.)
     * @throws MessagingException
     */
    @Test
    public void sendAttachmentsEmail() throws MessagingException {
        //这个是javax.mail.internet.MimeMessage下的，不要搞错了。
        MimeMessage mimeMessage =  mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //基本设置.
        helper.setFrom("316476844@qq.com");//发送者.
        helper.setTo("lvbin@oriental-finance.com");//接收者.
        helper.setSubject("测试附件（邮件主题）");//邮件主题.
        helper.setText("这是邮件内容（有附件哦.）");//邮件内容.
        //附件1,获取文件对象.
        FileSystemResource file1 = new FileSystemResource(new File("D:/41654.jpg"));
        //添加附件，这里第一个参数是在邮件中显示的名称，也可以直接是head.jpg，但是一定要有文件后缀，不然就无法显示图片了。
        helper.addAttachment("头像1.jpg", file1);
        //附件2
        FileSystemResource file2 = new FileSystemResource(new File("D:/api.html"));
        helper.addAttachment("api.html", file2);
        mailSender.send(mimeMessage);
    }

    /**
     * 邮件中使用静态资源.
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //基本设置.
        helper.setFrom("316476844@qq.com");//发送者.
        helper.setTo("lvbin@oriental-finance.com");//接收者.
        helper.setSubject("测试静态资源（邮件主题）");//邮件主题.
        // 邮件内容，第二个参数指定发送的是HTML格式
        //说明：嵌入图片<img src='cid:head'/>，其中cid:是固定的写法，而aaa是一个contentId。
        helper.setText("<body>这是图片：<img src='cid:head' /></body>", true);
        FileSystemResource file = new FileSystemResource(new File("D:/41654.jpg"));
        helper.addInline("head",file);
        mailSender.send(mimeMessage);
    }
}
