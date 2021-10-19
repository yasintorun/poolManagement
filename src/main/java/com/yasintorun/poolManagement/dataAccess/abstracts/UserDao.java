package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User getByUserId(int userId);
}
