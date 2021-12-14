package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
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
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<?> delete(@RequestBody User user) {
		return Ok(() -> this.userService.delete(user));
	}
	
	@PutMapping("updateuser")
	public ResponseEntity<?> update(@RequestBody User user) {
		return Ok(() -> this.userService.update(user));
	}
	
	@GetMapping("/getbyuserid")
	public ResponseEntity<?> getById(int userId) {
		return Ok(() -> this.userService.getById(userId));
	}
	
	@GetMapping("/getbyaccountid")
	public ResponseEntity<?> getByAuthId(int accountId) {
		return Ok(() -> this.userService.getByAccountId(accountId));
	}
}
