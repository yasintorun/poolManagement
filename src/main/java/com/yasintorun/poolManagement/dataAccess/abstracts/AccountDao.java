package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{
	Account getByEmail(String email);
}
