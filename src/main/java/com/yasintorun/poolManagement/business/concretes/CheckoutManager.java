package com.yasintorun.poolManagement.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yasintorun.poolManagement.business.abstracts.CheckoutService;
import com.yasintorun.poolManagement.business.abstracts.PaymentService;
import com.yasintorun.poolManagement.business.abstracts.UserPackageService;
import com.yasintorun.poolManagement.business.adapters.abstracts.BankService;
import com.yasintorun.poolManagement.core.utilities.helpers.DateHelper;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Payment;
import com.yasintorun.poolManagement.entities.concretes.PoolPackage;
import com.yasintorun.poolManagement.entities.concretes.User;
import com.yasintorun.poolManagement.entities.concretes.UserPackage;
import com.yasintorun.poolManagement.entities.dtos.PaymentDto;

@Service
public class CheckoutManager implements CheckoutService{
	private BankService bankService;
	private PaymentService paymentService;
	private UserPackageService userPackageService;
	
	@Autowired
	public CheckoutManager(BankService bankService, PaymentService paymentService, UserPackageService userPackageService) {
		super();
		this.bankService = bankService;
		this.paymentService = paymentService;
		this.userPackageService = userPackageService;
	}

	@Override
	@Transactional
	public Result check(PaymentDto payment) throws Exception {
		Result payResult = this.bankService.pay(payment.getCreditCard());
		
		if(!payResult.isSuccess()) {
			return payResult;
		}
		String createdAt = DateHelper.GetDateTime();
		Payment pay = new Payment(0, payment.getCreditCard().getCardNumber(), payment.getAmount(), createdAt, null, null);

		//ToDo: userId user tablosunda var mı kontrol et. 
		pay.setUser(new User());
		pay.getUser().setUserId(payment.getUserId());
		
		//ToDo: PackageId tabloda var mı kontrol et.
		pay.setPoolPackage(new PoolPackage());
		pay.getPoolPackage().setPackageId(payment.getPackageId());
		
		this.paymentService.add(pay);
		
		UserPackage userPackage = new UserPackage(0, createdAt, pay.getUser(), pay.getPoolPackage());
		
		this.userPackageService.add(userPackage);
		
		return payResult;
	}
	
}
