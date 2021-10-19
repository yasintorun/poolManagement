package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.dtos.ChangePasswordDto;

@RestController
@RequestMapping("api/accounts")
public class AccountController extends BaseController{
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService, ExceptionLogService exceptionService) {
		super(exceptionService);
		this.accountService = accountService;
	}
	
	@GetMapping("/getallaccounts")
	public ResponseEntity<?> getAll() {
		return Ok(() ->this.accountService.getAll());
	}
	
	@DeleteMapping("/deleteaccount")
	public ResponseEntity<?> delete(@RequestBody Account account) {
		return Ok(() ->this.accountService.delete(account));
	}
	
	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
		return Ok(() -> this.accountService.changePassword(changePasswordDto));
	}
}
