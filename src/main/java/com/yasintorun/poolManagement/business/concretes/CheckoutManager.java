package com.yasintorun.poolManagement.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yasintorun.poolManagement.business.abstracts.CheckoutService;
import com.yasintorun.poolManagement.business.abstracts.PaymentService;
import com.yasintorun.poolManagement.business.adapters.abstracts.BankService;
import com.yasintorun.poolManagement.core.utilities.helpers.DateHelper;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Payment;
import com.yasintorun.poolManagement.entities.concretes.User;
import com.yasintorun.poolManagement.entities.dtos.PaymentDto;

@Service
public class CheckoutManager implements CheckoutService{
	private BankService bankService;
	private PaymentService paymentService;
	
	@Autowired
	public CheckoutManager(BankService bankService, PaymentService paymentService) {
		super();
		this.bankService = bankService;
		this.paymentService = paymentService;
	}

	@Override
	@Transactional
	public Result check(PaymentDto payment) throws Exception {
		Result payResult = this.bankService.pay(payment.getCreditCard());
		
		if(!payResult.isSuccess()) {
			return payResult;
		}
		
		Payment pay = new Payment(0, payment.getCreditCard().getCardNumber(), payment.getAmount(), DateHelper.GetDateTime(), null);
		pay.setUser(new User());
		pay.getUser().setUserId(payment.getUserId());
		
		this.paymentService.add(pay);
		
		return payResult;
	}
	
}
