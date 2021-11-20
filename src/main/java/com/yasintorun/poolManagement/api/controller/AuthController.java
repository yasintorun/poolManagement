package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.AuthService;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.security.jwt.TokenManager;
import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.concretes.User;
import com.yasintorun.poolManagement.entities.dtos.LoginDto;

@RestController
@RequestMapping("api/auth")
public class AuthController extends BaseController{
	private AuthService authService;

	@Autowired
	private TokenManager tokenManager;
	
	@Autowired
	public AuthController(AuthService authService){
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		return Ok(() -> this.authService.register(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, @RequestHeader HttpHeaders headers) throws Exception {
		DataResult<?> login = this.authService.login(loginDto);
		if(!login.isSuccess()) {
			return ResponseEntity.badRequest().body(login);
		}
		//String token = tokenManager.generateToken(loginDto.getEmail());
		return ResponseEntity.ok(login);
	}
}
