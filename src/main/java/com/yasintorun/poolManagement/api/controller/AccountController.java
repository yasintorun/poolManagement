package com.yasintorun.poolManagement.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.entities.concretes.Account;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@GetMapping("getallaccounts")
	public List<Account> getAll() {
		return this.accountService.getAll();
	}
	
}
