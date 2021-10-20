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
import com.yasintorun.poolManagement.business.abstracts.PoolPackageService;
import com.yasintorun.poolManagement.entities.concretes.PoolPackage;

@RestController
@RequestMapping("api/poolpackages")
public class PoolPackageController extends BaseController{
	private PoolPackageService poolPackageService;

	@Autowired
	public PoolPackageController(PoolPackageService poolPackageService) {
		super();
		this.poolPackageService = poolPackageService;
	}
	
	@GetMapping("/getallpoolpackages")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.poolPackageService.getAll());
	}
	
	@PostMapping("/addpoolpackage")
	public ResponseEntity<?> add(@RequestBody PoolPackage poolPackage) {
		return Ok(() -> this.poolPackageService.add(poolPackage));
	}
	
	@PutMapping("/updatepoolpackage")
	public ResponseEntity<?> update(@RequestBody PoolPackage poolPackage) {
		return Ok(() -> this.poolPackageService.update(poolPackage));
	}
	
	@DeleteMapping("/deletepoolpackage")
	public ResponseEntity<?> delete(@RequestBody PoolPackage poolPackage) {
		return Ok(() -> this.poolPackageService.delete(poolPackage));
	}
	
}
