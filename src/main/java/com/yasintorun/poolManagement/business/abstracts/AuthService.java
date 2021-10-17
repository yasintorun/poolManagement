package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.concretes.User;
import com.yasintorun.poolManagement.entities.dtos.LoginDto;

public interface AuthService {
	DataResult<Account> login(LoginDto loginDto) throws Exception;
	Result register(User user) throws Exception;
}
