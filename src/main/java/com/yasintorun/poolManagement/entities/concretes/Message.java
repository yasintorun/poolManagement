package com.yasintorun.poolManagement.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "subject")
	private String subject;

	@Column(name = "message")
	private String message;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_read")
	private boolean isRead;

	@Column(name = "created_at")
	private LocalDate createdAt;
	
}
