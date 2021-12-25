package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.entities.concretes.PoolPackage;

public interface PoolPackageService extends CrudService<PoolPackage>{

	int poolPackageCount();

}
