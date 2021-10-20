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
import com.yasintorun.poolManagement.business.abstracts.UserPackageService;
import com.yasintorun.poolManagement.entities.concretes.UserPackage;

@RestController
@RequestMapping("api/userpackages")
public class UserPackageController extends BaseController{
	private UserPackageService userPackageService;

	@Autowired
	public UserPackageController(UserPackageService userPackageService) {
		super();
		this.userPackageService = userPackageService;
	}
	
	@GetMapping("/getalluserpapckages")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.userPackageService.getAll());
	}
	
	@PostMapping("/adduserpackage")
	public ResponseEntity<?> add(@RequestBody UserPackage userPackage) {
		return Ok(() -> this.userPackageService.add(userPackage));
	}
	
	@PutMapping("/updateuserpackage")
	public ResponseEntity<?> update(@RequestBody UserPackage userPackage) {
		return Ok(() -> this.userPackageService.update(userPackage));
	}
	
	@DeleteMapping("/deleteuserpackage")
	public ResponseEntity<?> delete(@RequestBody UserPackage userPackage) {
		return Ok(() -> this.userPackageService.delete(userPackage));
	}
	
}
