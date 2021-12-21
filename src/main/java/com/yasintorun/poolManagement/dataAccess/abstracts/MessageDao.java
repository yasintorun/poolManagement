package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.Message;

public interface MessageDao extends JpaRepository<Message, Integer> {
	
	Message getById(int id);
}
