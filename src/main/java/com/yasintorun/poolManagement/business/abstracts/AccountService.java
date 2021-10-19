package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Account;
import com.yasintorun.poolManagement.entities.dtos.ChangePasswordDto;

public interface AccountService extends CrudService<Account>{

	DataResult<Account> getByEmail(String email) throws Exception;
	Result validate(Account account) throws Exception;
	
	Result changePassword(ChangePasswordDto changePasswordDto) throws Exception;
}
