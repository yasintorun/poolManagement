package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.entities.concretes.ActivityContent;

public interface ActivityContentService extends CrudService<ActivityContent>{
	DataResult<ActivityContent> get(int id);
}
