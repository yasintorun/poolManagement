package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.ActivityService;
import com.yasintorun.poolManagement.entities.concretes.Activity;
import com.yasintorun.poolManagement.entities.dtos.ChangePasswordDto;

@RestController
@RequestMapping("api/activities")
public class ActivityController extends BaseController{
	private ActivityService activityService;

	@Autowired
	public ActivityController(ActivityService activityService) {
		super();
		this.activityService = activityService;
	}
	
	@GetMapping("/getallactivities")
	public ResponseEntity<?> getAll() {
		return Ok(() ->this.activityService.getAll());
	}
	
	@GetMapping("/getactivity")
	public ResponseEntity<?> getById(int id) {
		return Ok(() ->this.activityService.get(id));
	}
	
	@PostMapping("/addactivity")
	public ResponseEntity<?> add(@RequestBody Activity activity) {
		return Ok(() -> this.activityService.add(activity));
	}
	
}
