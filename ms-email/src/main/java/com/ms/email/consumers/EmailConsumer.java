package com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.entities.Email;
import com.ms.email.service.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired
	private EmailService service;
	
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailDTO dto) {
		var email = new Email();
		BeanUtils.copyProperties(dto, email);
		service.sendEmail(email);	
	}
}