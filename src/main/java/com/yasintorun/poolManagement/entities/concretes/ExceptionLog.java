package com.yasintorun.poolManagement.entities.concretes;

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
@Table(name = "exception_logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="log_id")
	private int logId;
	
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="log_message")
	private String logMessage;
	
	@Column(name="log_time")
	private String logTime;
}
