package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.business.abstracts.PoolService;
import com.yasintorun.poolManagement.entities.concretes.Pool;

@RestController
@RequestMapping("api/pools")
public class PoolController extends BaseController{
	private PoolService poolService;

	@Autowired
	public PoolController(PoolService poolService) {
		super();
		this.poolService = poolService;
	}

	@GetMapping("getallpools2")
	public ResponseEntity<?> getAll2() {
		return Ok(() -> this.poolService.getAll());
	}
	
	@GetMapping("getallpools")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.poolService.getAllWithImages());
	}
	
	@PostMapping("addpool")
	public ResponseEntity<?> add(@RequestBody Pool pool) {
		return Ok(() -> this.poolService.add(pool));
	}
	
	@DeleteMapping("deletepool")
	public ResponseEntity<?> delete(@RequestBody Pool pool) {
		return Ok(() -> this.poolService.delete(pool));
	}
	
	@PutMapping("updatepool")
	public ResponseEntity<?> update(@RequestBody Pool pool) {
		return Ok(() -> this.poolService.update(pool));
	}
	
}
