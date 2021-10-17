package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.entities.concretes.Account;

public interface AccountService extends CrudService<Account>{

	DataResult<Account> getByEmail(String email) throws Exception;
}
