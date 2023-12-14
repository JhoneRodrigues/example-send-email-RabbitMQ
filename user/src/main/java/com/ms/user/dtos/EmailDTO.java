package com.ms.user.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO{
	
	private UUID userId;
	private String emailTo;
	private String subject;
	private String text;
}
