package com.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.project.service.mailService;

@Component
public class mailServiceImpl implements mailService {
	
    @Autowired
    private JavaMailSender mailSender;
    
    public void notfiyEmail (String to, String subject, String msg ){
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(msg);
        mailSender.send(email);
    	
    }
	
	public void sendEmail(String to ,int req_id ,int user_id){
		
		SimpleMailMessage email = new SimpleMailMessage();

	}

}
