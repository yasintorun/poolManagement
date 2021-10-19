package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.UserService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.BusinessRules;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
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
		User updateUser = this.userDao.save(entity);
		return new SuccessDataResult<User>(updateUser, Messages.userUpdated);
	}

	@Override
	public Result delete(User entity) {
		this.userDao.delete(entity);
		return new SuccessResult(Messages.userDeleted);
	}

	@Override
	public Result validate(User user) {
		Result result = BusinessRules.Run(isNull(user));
		if(result != null) {
			return result;
		}
		return new SuccessResult();
	}
	
	public Result isNull(User user) {
		if(user.getFirstname().isBlank() || user.getLastname().isBlank()) {
			return new ErrorResult("Tüm alanlar zorunludur");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<User> getById(int userId) {
		User user = this.userDao.getByUserId(userId);
		if(user == null) {
			return new ErrorDataResult<User>(Messages.userNotFound);
		}
		user.getAccount().setPassword(null);
		return new SuccessDataResult<User>(user, Messages.userGot);
	}
	
	
	
}
