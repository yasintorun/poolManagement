package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.PaymentService;

@RestController
@RequestMapping("api/payments")
public class PaymentController extends BaseController{
	private PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@GetMapping("/getallpayments")
	public ResponseEntity<?> getAll() {
		return Ok(() -> this.paymentService.getAll());
	}
	
}
