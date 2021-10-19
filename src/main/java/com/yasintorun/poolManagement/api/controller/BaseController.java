package com.yasintorun.poolManagement.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.business.concretes.ExceptionLogManager;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.helpers.DateHelper;
import com.yasintorun.poolManagement.dataAccess.abstracts.ExceptionLogDao;
import com.yasintorun.poolManagement.entities.concretes.ExceptionLog;

public class BaseController {
	private ExceptionLogService exceptionLogService;
	
	public BaseController() {
		
	}
	
	@Autowired
	public BaseController(ExceptionLogService exceptionLogService) {
		super();
		this.exceptionLogService = exceptionLogService;
	}



	public <T> ResponseEntity<?> Ok(Callable<T> call) {
		try {
			T t = call.call();
			return ResponseEntity.ok(t);
		}catch(Exception e) {
			
			
			this.exceptionLogService.log(new ExceptionLog(0, -1, e.getMessage(), DateHelper.GetDateTime()));
			
			return ResponseEntity.badRequest().body(Messages.errorOccurred); //hata oluştuğunda kullanıcının göreceği mesaj
		}
	}
}
