package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
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
		accounts = this.accountDao.findAll();
		return new SuccessDataResult<List<Account>>(accounts, Messages.accountListed);
	}
	@Override
	public DataResult<Account> add(Account entity) {
		Account addedAccount = this.accountDao.save(entity);
		return new SuccessDataResult<Account>(addedAccount, Messages.accountAdded);
	}
	@Override
	public DataResult<Account> update(Account entity) {
		Account updatedAccount = this.accountDao.save(entity);
		return new SuccessDataResult<Account>(updatedAccount, Messages.accountUpdated);
	}
	@Override
	public Result delete(Account entity) {
		this.accountDao.delete(entity);
		return new SuccessResult(Messages.accountDeleted);
	}
}
