package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.UserPackage;

public interface UserPackageDao extends JpaRepository<UserPackage, Integer>{
	
}
