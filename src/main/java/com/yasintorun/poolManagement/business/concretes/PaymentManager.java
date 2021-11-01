package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.PaymentService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.PaymentDao;
import com.yasintorun.poolManagement.entities.concretes.Payment;

@Service
public class PaymentManager implements PaymentService{
	private PaymentDao paymentDao;
	
	@Autowired
	public PaymentManager(PaymentDao paymentDao) {
		super();
		this.paymentDao = paymentDao;
	}

	@Override
	public DataResult<List<Payment>> getAll() throws Exception {
		return new SuccessDataResult<List<Payment>>(this.paymentDao.findAll(), Messages.paymentListed);
	}

	@Override
	public DataResult<Payment> add(Payment entity) throws Exception {
		Payment pay = this.paymentDao.save(entity);
		return new SuccessDataResult<Payment>(pay, Messages.paymentAdded);
	}

	@Override
	public DataResult<Payment> update(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
