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

import com.yasintorun.poolManagement.business.abstracts.AppointmentService;
import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.entities.concretes.Appointment;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController extends BaseController{
	private AppointmentService appointmentService;

	@Autowired
	public AppointmentController(AppointmentService appointmentService, ExceptionLogService exceptionLogService) {
		super(exceptionLogService);
		this.appointmentService = appointmentService;
	}
	
	@GetMapping("/getallappointments")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.appointmentService.getAll());
	}
	
	@PostMapping("/addappointment")
	public ResponseEntity<?> add(@RequestBody Appointment appointment) {
		return Ok(() -> this.appointmentService.add(appointment));
	}
	
	@PutMapping("/updateappointment")
	public ResponseEntity<?> update(@RequestBody Appointment appointment) {
		return Ok(() -> this.appointmentService.update(appointment));
	}
	
	@DeleteMapping("/deleteappointment")
	public ResponseEntity<?> delete(@RequestBody Appointment appointment) {
		return Ok(() -> this.appointmentService.delete(appointment));
	}
	
}
