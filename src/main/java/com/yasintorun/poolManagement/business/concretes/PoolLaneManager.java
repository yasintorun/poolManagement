package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.PoolLaneService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.exceptions.EntityNotFound;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.PoolLaneDao;
import com.yasintorun.poolManagement.entities.concretes.PoolLane;

@Service
public class PoolLaneManager implements PoolLaneService{
	private PoolLaneDao poolLaneDao;

	@Autowired
	public PoolLaneManager(PoolLaneDao poolLaneDao) {
		super();
		this.poolLaneDao = poolLaneDao;
	}

	@Override
	public DataResult<List<PoolLane>> getAll() throws Exception {
		Sort sort = Sort.by(Sort.Direction.ASC, "laneId");
		return new SuccessDataResult<List<PoolLane>>(this.poolLaneDao.findAll(sort), Messages.poolLaneListed);
	}

	@Override
	public DataResult<PoolLane> add(PoolLane entity) throws Exception {
		PoolLane addedLane = this.poolLaneDao.save(entity);
		return new SuccessDataResult<PoolLane>(addedLane, Messages.poolLaneAdded);
	}

	@Override
	public DataResult<PoolLane> update(PoolLane entity) throws Exception {
		if(!this.poolLaneDao.existsByLaneId(entity.getLaneId())) {
			throw new EntityNotFound("poolLane");
		}
		PoolLane updatedLane = this.poolLaneDao.save(entity);
		return new SuccessDataResult<PoolLane>(updatedLane, Messages.poolLaneUpdated);
	}

	@Override
	public Result delete(PoolLane entity) throws Exception {
		if(!this.poolLaneDao.existsByLaneId(entity.getLaneId())) {
			throw new EntityNotFound("poolLane");
		}
		
		this.poolLaneDao.delete(entity);
		
		return new SuccessResult(Messages.poolLaneDeleted);
	}
	
}
