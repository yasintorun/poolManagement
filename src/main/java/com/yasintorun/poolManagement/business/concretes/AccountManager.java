package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
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
	public List<Account> getAll() {
		return this.accountDao.findAll();
	}
	
}
