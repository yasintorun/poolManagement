package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.entities.concretes.Account;

@RestController
@RequestMapping("api/accounts")
public class AccountController extends BaseController{
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@GetMapping("/getallaccounts")
	public ResponseEntity<?> getAll() {
		return Ok(() ->this.accountService.getAll());
	}
	
	@PostMapping("/addaccount")
	public ResponseEntity<?> add(@RequestBody Account account) {
		return Ok(() ->this.accountService.add(account));
	}
	
}
