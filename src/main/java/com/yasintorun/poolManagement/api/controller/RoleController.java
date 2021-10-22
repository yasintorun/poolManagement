package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.RoleService;

@RestController
@RequestMapping("api/roles")
public class RoleController extends BaseController{
	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	
	@GetMapping("getalloperationclaims")
	public ResponseEntity<?> getAll() {
		return Ok(()-> this.roleService.getAll());
	}
}
