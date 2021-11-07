package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.entities.concretes.UserPackage;

public interface UserPackageService extends CrudService<UserPackage>{
	DataResult<UserPackage> getByUserId(int userId);
}
