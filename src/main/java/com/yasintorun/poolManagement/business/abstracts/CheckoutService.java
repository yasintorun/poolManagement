package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.dtos.PaymentDto;

public interface CheckoutService {
	Result check(PaymentDto payment) throws Exception;
}
