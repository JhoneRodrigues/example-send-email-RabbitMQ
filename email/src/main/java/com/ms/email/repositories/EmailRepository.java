package com.ms.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.email.entities.Email;

public interface EmailRepository extends JpaRepository<Email, UUID>{

}
