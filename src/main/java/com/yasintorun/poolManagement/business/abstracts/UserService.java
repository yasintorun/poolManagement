package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.User;

public interface UserService extends CrudService<User>{
	Result validate(User user) throws Exception;
}
