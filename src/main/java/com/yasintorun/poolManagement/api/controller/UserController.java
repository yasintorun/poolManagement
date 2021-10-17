package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.UserService;
import com.yasintorun.poolManagement.entities.concretes.User;

@RestController
@RequestMapping("api/users")
public class UserController extends BaseController{
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.userService.getAll());
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<?> add(@RequestBody User user) {
		return Ok(() -> this.userService.add(user));
	}
}
