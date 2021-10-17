package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import com.yasintorun.poolManagement.entities.concretes.Account;

public interface AccountService {
	List<Account> getAll();
}
