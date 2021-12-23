package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.ActivityContentService;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.ActivityContentDao;
import com.yasintorun.poolManagement.entities.concretes.ActivityContent;

@Service
public class ActivityContentManager implements ActivityContentService{
	private ActivityContentDao activityContentDao;
	
	@Autowired
	public ActivityContentManager(ActivityContentDao activityContentDao) {
		super();
		this.activityContentDao = activityContentDao;
	}

	@Override
	public DataResult<List<ActivityContent>> getAll() throws Exception {
		return new SuccessDataResult<List<ActivityContent>>(this.activityContentDao.findAll());
	}

	@Override
	public DataResult<ActivityContent> add(ActivityContent entity) throws Exception {
		ActivityContent addedAC = this.activityContentDao.save(entity);
		return new SuccessDataResult<ActivityContent>(addedAC, "Etkinlik içeriği oluşturuldu");
	}

	@Override
	public DataResult<ActivityContent> update(ActivityContent entity) throws Exception {
		ActivityContent updatedAC = this.activityContentDao.save(entity);
		return new SuccessDataResult<ActivityContent>(updatedAC, "Etkinlik içeriği düzenlendi");
	}

	@Override
	public Result delete(ActivityContent entity) throws Exception {
		this.activityContentDao.deleteById(entity.getId());
		return new SuccessResult("Etkinlik içeriği silindi");
	}

	@Override
	public DataResult<ActivityContent> get(int id) {
		ActivityContent getAC = this.activityContentDao.getById(id);
		return new SuccessDataResult<ActivityContent>(getAC, "Etkinlik içeriği getirildi");
	}

}
