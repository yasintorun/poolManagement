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

import com.yasintorun.poolManagement.business.abstracts.ActivityContentService;
import com.yasintorun.poolManagement.business.abstracts.ActivityService;
import com.yasintorun.poolManagement.entities.concretes.Activity;
import com.yasintorun.poolManagement.entities.concretes.ActivityContent;
import com.yasintorun.poolManagement.entities.dtos.ChangePasswordDto;

@RestController
@RequestMapping("api/activitycontents")
public class ActivityContentController extends BaseController{
	private ActivityContentService activityContentService;

	@Autowired
	public ActivityContentController(ActivityContentService activityContentService) {
		super();
		this.activityContentService = activityContentService;
	}
	
	@GetMapping("/getallactivitycontents")
	public ResponseEntity<?> getAll() {
		return Ok(() ->this.activityContentService.getAll());
	}
	
	@GetMapping("/getactivitycontent")
	public ResponseEntity<?> getById(int id) {
		return Ok(() ->this.activityContentService.get(id));
	}
	
	@PostMapping("/addactivitycontent")
	public ResponseEntity<?> add(@RequestBody ActivityContent activity) {
		return Ok(() -> this.activityContentService.add(activity));
	}
	
	@DeleteMapping("/deleteactivitycontent")
	public ResponseEntity<?> delete(@RequestBody ActivityContent activity) {
		return Ok(() -> this.activityContentService.delete(activity));
	}
	
	@PutMapping("/addactivitycontent")
	public ResponseEntity<?> update(@RequestBody ActivityContent activity) {
		return Ok(() -> this.activityContentService.update(activity));
	}
	
}
