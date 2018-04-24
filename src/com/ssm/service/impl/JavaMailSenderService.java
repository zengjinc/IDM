package com.ssm.service.impl;

import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ssm.service.IJavaMailSenderService;
import com.ssm.utils.properties.ConfigEmailUtil;

@Service
public class JavaMailSenderService implements IJavaMailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void entitlementFinishEmail(String sendTo,String userName,String resourceId,String loginId,String password) throws Exception{
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(ConfigEmailUtil.getInstance().getValueByKey("username"));
        helper.setTo(sendTo);
        helper.setSubject("账号授权完成");
        
        VelocityContext context = new VelocityContext();
        context.put("userName", userName);
        context.put("resourceId", resourceId);
        context.put("loginId", loginId);
        context.put("password", password);
        
        Template template = new VelocityEngine().getTemplate("temp/etm_finish.vm", "utf-8");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        String text = sw.toString();
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
		
	}
	
	@Override
	public void entitlementCancelEmail(String sendTo,String userName,String resourceId,String loginId) throws Exception{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(ConfigEmailUtil.getInstance().getValueByKey("username"));
        helper.setTo(sendTo);
        helper.setSubject("收回账号授权");
        
        VelocityContext context = new VelocityContext();
        context.put("userName", userName);
        context.put("resourceId", resourceId);
        context.put("loginId", loginId);
        
        Template template = new VelocityEngine().getTemplate("temp/etm_cancel.vm", "utf-8");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        String text = sw.toString();
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
	}
	
	@Override
	public void entitlementEnableEmail(String sendTo,String userName,String resourceId,String loginId) throws Exception{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(ConfigEmailUtil.getInstance().getValueByKey("username"));
        helper.setTo(sendTo);
        helper.setSubject("激活账号");
        
        VelocityContext context = new VelocityContext();
        context.put("userName", userName);
        context.put("resourceId", resourceId);
        context.put("loginId", loginId);
        
        Template template = new VelocityEngine().getTemplate("temp/etm_enable.vm", "utf-8");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        String text = sw.toString();
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
	}
	
	@Override
	public void entitlementDisableEmail(String sendTo, String userName, String resourceId, String loginId) throws Exception{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(ConfigEmailUtil.getInstance().getValueByKey("username"));
        helper.setTo(sendTo);
        helper.setSubject("禁用账号");
        
        VelocityContext context = new VelocityContext();
        context.put("userName", userName);
        context.put("resourceId", resourceId);
        context.put("loginId", loginId);
        
        Template template = new VelocityEngine().getTemplate("temp/etm_disable.vm", "utf-8");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        String text = sw.toString();
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
	}
	
	@Override
	public void changePasswordEmail(String sendTo,String userName,String resourceId,String loginId,String password) throws Exception{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(ConfigEmailUtil.getInstance().getValueByKey("username"));
        helper.setTo(sendTo);
        helper.setSubject("修改账号密码");
        
        VelocityContext context = new VelocityContext();
        context.put("userName", userName);
        context.put("resourceId", resourceId);
        context.put("loginId", loginId);
        context.put("password", password);
        
        Template template = new VelocityEngine().getTemplate("temp/change_password.vm", "utf-8");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        String text = sw.toString();
        helper.setText(text, true);
        javaMailSender.send(mimeMessage);
	}
	
}
