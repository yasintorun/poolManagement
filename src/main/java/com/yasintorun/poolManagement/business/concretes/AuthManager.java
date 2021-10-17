package com.yasintorun.poolManagement.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AccountService;
import com.yasintorun.poolManagement.business.abstracts.AuthService;
import com.yasintorun.poolManagement.business.abstracts.UserService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.AccountDao;
import com.yasintorun.poolManagement.dataAccess.abstracts.UserDao;
import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.concretes.User;
import com.yasintorun.poolManagement.entities.dtos.loginDto;

@Service
public class AuthManager implements AuthService{
	private AccountService accountService;
	private UserService userService;
	
	@Autowired
	public AuthManager(AccountService accountService, UserService userService) {
		super();
		this.accountService = accountService;
		this.userService = userService;
	}

	@Override
	public DataResult<Account> login(loginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result register(User user) throws Exception {
		DataResult<Account> accountAddResult = null;
		
		accountAddResult = this.accountService.add(user.getAccount());					
		
		try {
			user.setAccount(accountAddResult.getData());
			this.userService.add(user);
		} catch(Exception e) {
			this.accountService.delete(accountAddResult.getData());
			throw e;
		}
		return new SuccessResult(Messages.registerSuccessfully);
	}
}
