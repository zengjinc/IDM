package com.test;

import java.io.File;
import java.io.StringWriter;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
public class JavaMailSenderTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void testSimpleTextMail(){   //发送普通文本邮件

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("zengjinc_zp@163.com");// 发送者，可选的
        mailMessage.setTo("chen_zengjin@126.com");//接受者
        mailMessage.setSubject("测试邮件");//主题
        mailMessage.setText("Test Email send by javaMailSender!");//邮件内容

        javaMailSender.send(mailMessage);
    }

    @Test
    public void testMimeMail() throws Exception {   //发送HTML格式的邮件

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("zengjinc_zp@163.com");
        helper.setTo("chen_zengjin@126.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><a href=\"http://www.baidu.com\" ></body></html>", true);

        javaMailSender.send(mimeMessage);
    }

    @Test
    public void testMimeInlineMail() throws Exception { //发送HTML格式含图片的邮件

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("FX_SKY");
        helper.setTo("ricky_feng@163.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:logo\" ></body></html>", true);
        FileSystemResource logoFile = new FileSystemResource(new File("logo.jpg"));
        helper.addInline("logo", logoFile);

        javaMailSender.send(mimeMessage);
    }

    @Test
    public void testAttachmentMail() throws Exception { //发送含附件的邮件

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);// 第二个参数设置为true，表示允许添加附件
        helper.setFrom("FX_SKY");
        helper.setTo("ricky_feng@163.com");
        helper.setSubject("发送含图片附件的邮件");
        helper.setText("含有附件的邮件");

        helper.addAttachment(MimeUtility.encodeText("附件-1.jpg"), new File("E:/attachment1.jpg"));
        helper.addAttachment(MimeUtility.encodeText("附件-2.jpg"), new File("E:/attachment2.jpg"));

        javaMailSender.send(mimeMessage);
    }
    
    @Test
    public void testSendTemplateMail() throws Exception {	//发送模板邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("zengjinc_zp@163.com");
        helper.setTo("chen_zengjin@126.com");
        helper.setSubject("主题：模板邮件");
        
        VelocityContext context = new VelocityContext();
        context.put("username", "Velocity");
        context.put("activation_url", "http://www.baidu.com");
        Template template = new VelocityEngine().getTemplate("config/template/mail.vm", "utf-8");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        String text = sw.toString();
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
    }

}

