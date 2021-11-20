package com.yasintorun.poolManagement.api.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.helpers.DateHelper;
import com.yasintorun.poolManagement.entities.concretes.ExceptionLog;

@CrossOrigin
public class BaseController {
	@Autowired
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
			System.out.println(e.getMessage());
			this.exceptionLogService.log(new ExceptionLog(0, -1, e.getMessage(), DateHelper.GetDateTime()));
			return ResponseEntity.badRequest().body(Messages.errorOccurred); //hata oluştuğunda kullanıcının göreceği mesaj
		}
	}
	
	public void ClaimControl() {
		
	}
}
