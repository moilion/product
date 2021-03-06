package com.example.conf;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	@Value("${mail.host}")
	private String host;
	
	@Value("${mail.user}")
	private String user;
	
	@Value("${mail.pass}")
	private String pass;
	
	@Value("${mail.port}")
	private int port;
	
	@Bean
	public JavaMailSender javaMailSender(){
		
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost(host);
		mail.setUsername(user);
		mail.setPassword(pass);
		mail.setPort(port);
		
		Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.debug", "true");

		
		mail.setJavaMailProperties( properties);
		
		return mail;
	}
}
