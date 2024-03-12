package com.ms.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.dtos.EmailDTO;
import com.ms.user.entities.User;

@Component
public class UserProducer {
	
	@Autowired
	private RabbitTemplate template;
	
	@Value (value = "${broker.queue.email.name}")
	private String routingKey;
	
	public void publishMessageEmail(User user) {
		var emailDTO = new EmailDTO();
		emailDTO.setUserId(user.getId());
		emailDTO.setEmailTo(user.getEmail());
		emailDTO.setSubject("Cadastro realizado com sucesso!");
		emailDTO.setText(user.getName() + ", seja bem vindo(a)!\nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");
		
		template.convertAndSend("", routingKey, emailDTO);
	}
}
