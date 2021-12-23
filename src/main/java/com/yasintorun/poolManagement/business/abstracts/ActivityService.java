package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Activity;

public interface ActivityService {
	DataResult<List<Activity>> getAll();
	DataResult<Activity> get(int id);
	Result add(Activity activity);
}
