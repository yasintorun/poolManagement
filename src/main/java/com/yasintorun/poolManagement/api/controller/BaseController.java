package com.yasintorun.poolManagement.api.controller;

import java.util.concurrent.Callable;

import org.springframework.http.ResponseEntity;

import com.yasintorun.poolManagement.business.constants.Messages;

public class BaseController {

	public <T> ResponseEntity<?> Ok(Callable<T> call) {
		try {
			T t = call.call();
			return ResponseEntity.ok(t);
		}catch(Exception e) {
			//TODO: Loglama işlemlerini burada hallet.
			return ResponseEntity.badRequest().body(Messages.errorOccurred); //hata oluştuğunda kullanıcının göreceği mesaj
		}
	}
}
