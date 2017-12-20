package com.lingua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.lingua.model.Mail;

@Component
public class EmailService {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(String to, String subject, String text) {
 
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
    
    public void sendNotifyToAdmin(){
    	SimpleMailMessage message = new SimpleMailMessage();
        Mail mail = new Mail();
        mail.setTo("lingua.webapp@gmail.com");
        mail.setSubject("Lingua Service No-reply");
        mail.setContent("There is some news for you!");
        
        message.setTo(mail.getTo()); 
        message.setSubject(mail.getSubject()); 
        message.setText(mail.getContent());
        
        emailSender.send(message);
    }
}
