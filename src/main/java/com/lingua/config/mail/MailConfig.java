package com.lingua.config.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class MailConfig {
	
	@Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties mailProperties = new Properties();
	        mailProperties.put("mail.transport.protocol", "smtp");
	        mailProperties.put("mail.smtp.auth", "true");
	        mailProperties.put("mail.smtp.starttls.enable", "true");
	        mailProperties.put("mail.debug", "true");
	        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        
	        mailSender.setJavaMailProperties(mailProperties);
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("lingua.webapp@gmail.com");
	        mailSender.setPassword("linguawebapp");
        return mailSender;
    }
	
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setSubject("Wellcome to LinguaApp");
	    message.setText(
	       		"\n\n"
	      		+ "Wellcome to Lingua web app platform! Nice to meet you. :) My name is Nemanja and I am your administrator."
	      		+ "\n\n"
	      		+ "You have just signed up to our service and you will get our response ASAP. "
	      		+ "If you have any questions, please let me know.\n\n"
	      		+ "Thank you for coming."
	      		+ "\n"
	      		+ "\n"
	      		+ "Nemanja\n"
	      		+ "lingua.webapp@gmail.com");
	    return message;
	}

}
