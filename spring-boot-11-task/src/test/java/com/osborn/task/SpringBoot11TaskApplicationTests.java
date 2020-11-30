package com.osborn.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot11TaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void test() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮箱设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7点30准时开会，不要迟到哦");

        message.setTo("hanqh_0o0@126.com");
        message.setFrom("hanqh_0o0@163.com");
        javaMailSender.send(message);
    }

    @Test
    public void contextLoads() {
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            //邮箱设置
            mimeMessageHelper.setSubject("通知-今晚开会");
            mimeMessageHelper.setText("<b style='color:red'>你好，我是红色，嘻嘻嘻</b> <hr/>" +
                    "<b style='color:blue'>你好，我是蓝色，嘻嘻嘻</b> <hr/>" +
                    "<b style='color:pink'>你好，我是粉红色，嘻嘻嘻</b> <hr/>" +
                    "<b style='color:green'>你好，我是绿色，嘻嘻嘻</b> <hr/>", true);
            mimeMessageHelper.setTo("hanqh_0o0@126.com");
            mimeMessageHelper.setFrom("hanqh_0o0@163.com");

            //上传文件
            mimeMessageHelper.addAttachment("1.jpg", new File("C:/Users/Administrator/Desktop/example/1.jpg"));
            mimeMessageHelper.addAttachment("2.jpg", new File("C:/Users/Administrator/Desktop/example/2.jpg"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }

}
