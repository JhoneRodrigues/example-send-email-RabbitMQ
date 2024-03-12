package com.ms.email.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.entities.Email;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository repository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Value(value = "${spring.mail.username}")
	private String emailFrom;
	
	@Transactional
	public Email sendEmail(Email email) {
		try {
			email.setSendDateEmail(LocalDateTime.now());
			email.setEmailFrom(emailFrom);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			emailSender.send(message);
			
			email.setStatus(StatusEmail.SENT);
		} catch(MailException e) {
			email.setStatus(StatusEmail.ERROR);
		} finally {
			return repository.save(email);
		}
	}
}
