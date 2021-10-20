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
import com.yasintorun.poolManagement.business.abstracts.PoolLaneService;
import com.yasintorun.poolManagement.entities.concretes.PoolLane;

@RestController
@RequestMapping("api/poollanes")
public class PoolLaneController extends BaseController{
	private PoolLaneService poolLaneService;

	@Autowired
	public PoolLaneController(PoolLaneService poolLaneService ) {
		super();
		this.poolLaneService = poolLaneService;
	}
	
	@GetMapping("getallpoollanes")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.poolLaneService.getAll());
	}
	
	@PostMapping("addpoollane")
	public ResponseEntity<?> add(@RequestBody PoolLane poolLane) {
		return Ok(() -> this.poolLaneService.add(poolLane));
	}
	
	@DeleteMapping("deletepoollane")
	public ResponseEntity<?> delete(@RequestBody PoolLane poolLane) {
		return Ok(() -> this.poolLaneService.delete(poolLane));
	}
	
	@PutMapping("updatepoollane")
	public ResponseEntity<?> update(@RequestBody PoolLane poolLane) {
		return Ok(() -> this.poolLaneService.update(poolLane));
	}
}
