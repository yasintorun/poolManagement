package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.ActivityService;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.ActivityDao;
import com.yasintorun.poolManagement.entities.concretes.Activity;

@Service
public class ActivityManager implements ActivityService{
	private ActivityDao activityDao;
	
	@Autowired
	public ActivityManager(ActivityDao activityDao) {
		super();
		this.activityDao = activityDao;
	}

	@Override
	public DataResult<List<Activity>> getAll() {
		return new SuccessDataResult<List<Activity>>(this.activityDao.findAll(), "Etkinlikler listelendi");
	}

	@Override
	public DataResult<Activity> get(int id) {
		return new SuccessDataResult<Activity>(this.activityDao.getById(id), "Etkinlik getirildi");
	}

	@Override
	public Result add(Activity activity) {
		Activity addedActivity = this.activityDao.save(activity);
		return new SuccessResult("Etkinlik eklendi");
	}
	
}
