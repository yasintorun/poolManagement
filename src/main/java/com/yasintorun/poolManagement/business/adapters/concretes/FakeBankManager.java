package com.yasintorun.poolManagement.business.adapters.concretes;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.adapters.abstracts.BankService;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.entities.dtos.CreditCard;

@Service
public class FakeBankManager implements BankService{
	
	@Override
	public Result pay(CreditCard card) {
		Random rand = new Random();
		if(rand.nextBoolean()) {
			return new ErrorResult("Bakiye yetersiz");
		}
		return new SuccessResult("Ödeme Başarılı");
	}
	
}
