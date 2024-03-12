package com.ms.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.user.entities.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserProducer producer;
	
	@Transactional
	public User save (User entity) {
		entity = repository.save(entity);
		producer.publishMessageEmail(entity);
		return entity;
	}
}
