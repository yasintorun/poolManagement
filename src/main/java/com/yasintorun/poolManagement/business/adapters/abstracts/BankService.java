package com.yasintorun.poolManagement.business.adapters.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.dtos.CreditCard;

public interface BankService {
	Result pay(CreditCard card);
}
