package com.ms.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dtos.UserDTO;
import com.ms.user.entities.User;
import com.ms.user.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO request){
		var entity = new User();
		BeanUtils.copyProperties(request, entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
}
