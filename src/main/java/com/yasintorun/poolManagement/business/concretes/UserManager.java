package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.UserService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.UserDao;
import com.yasintorun.poolManagement.entities.concretes.User;

@Service
public class UserManager implements UserService {
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.userListed);
	}

	@Override
	public DataResult<User> add(User entity) {
		User addUser = this.userDao.save(entity);
		return new SuccessDataResult<User>(addUser, Messages.userAdded);
	}

	@Override
	public DataResult<User> update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(User entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
