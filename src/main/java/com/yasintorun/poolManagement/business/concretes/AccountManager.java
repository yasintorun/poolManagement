package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.AccountDao;
import com.yasintorun.poolManagement.entities.concretes.Account;

@Service
public class AccountManager implements AccountService {
	private AccountDao accountDao;
	
	@Autowired
	public AccountManager(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}
	@Override
	public DataResult<List<Account>> getAll() {
		List<Account> accounts = null;
		try {
			accounts = this.accountDao.findAll();
		} catch(Exception e) {
			return new ErrorDataResult<List<Account>>(Messages.errorOccurred);
		}
		return new SuccessDataResult<List<Account>>(accounts, Messages.accountListed);
	}
}
