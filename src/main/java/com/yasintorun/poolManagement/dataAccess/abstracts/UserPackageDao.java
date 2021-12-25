package com.yasintorun.poolManagement.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.UserPackage;

public interface UserPackageDao extends JpaRepository<UserPackage, Integer>{
	UserPackage getByUser_UserId(int userId);
	List<UserPackage> getByStatus(boolean status);
}
