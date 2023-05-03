package com.subodh.intergrationservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.subodh.intergrationservice.dto.EmailDto;
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    
	public void SendMail(EmailDto dto) {
	
	SimpleMailMessage mailMessage = new SimpleMailMessage();

	mailMessage.setFrom(dto.getSubject());
    mailMessage.setTo(dto.getTo());
    mailMessage.setText(dto.getBody());
    mailMessage.setSubject(dto.getFrom());
    
 // Sending the mail
    javaMailSender.send(mailMessage);
	}
	
}
