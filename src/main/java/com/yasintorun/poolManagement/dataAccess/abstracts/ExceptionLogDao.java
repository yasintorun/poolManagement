package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.ExceptionLog;

public interface ExceptionLogDao extends JpaRepository<ExceptionLog, Integer>{
	
}
