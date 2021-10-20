package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.UserPackageService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.UserPackageDao;
import com.yasintorun.poolManagement.entities.concretes.UserPackage;

@Service
public class UserPackageManager implements UserPackageService{
	private UserPackageDao userPackageDao;

	@Autowired
	public UserPackageManager(UserPackageDao userPackageDao) {
		super();
		this.userPackageDao = userPackageDao;
	}

	@Override
	public DataResult<List<UserPackage>> getAll() throws Exception {
		return new SuccessDataResult<List<UserPackage>>(this.userPackageDao.findAll(), Messages.userPackageListed);
	}

	@Override
	public DataResult<UserPackage> add(UserPackage entity) throws Exception {
		UserPackage addedUserPackage = this.userPackageDao.save(entity);
		
		return new SuccessDataResult<UserPackage>(addedUserPackage, Messages.userPackageAdded);
	}

	@Override
	public DataResult<UserPackage> update(UserPackage entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(UserPackage entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
