package com.yasintorun.poolManagement.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.CheckoutService;
import com.yasintorun.poolManagement.entities.dtos.PaymentDto;

@RestController
@RequestMapping("api/checkout")
public class CheckoutController extends BaseController{
	private CheckoutService checkoutService;

	@Autowired
	public CheckoutController(CheckoutService checkoutService) {
		super();
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/check")
	public ResponseEntity<?> check(@RequestBody PaymentDto payment) {
		return Ok(() -> this.checkoutService.check(payment));
	}
}
