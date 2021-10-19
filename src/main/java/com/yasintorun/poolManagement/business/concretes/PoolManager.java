package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.PoolService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.PoolDao;
import com.yasintorun.poolManagement.entities.concretes.Pool;

@Service
public class PoolManager implements PoolService {
	private PoolDao poolDao;
	
	@Autowired
	public PoolManager(PoolDao poolDao) {
		super();
		this.poolDao = poolDao;
	}

	@Override
	public DataResult<List<Pool>> getAll() throws Exception {
		return new SuccessDataResult<List<Pool>>(this.poolDao.findAll(), Messages.poolListed);
	}

	@Override
	public DataResult<Pool> add(Pool entity) throws Exception {
		if(entity.getPoolAddress().isBlank() || entity.getPoolName().isBlank()) {
			return new ErrorDataResult<Pool>(Messages.allFieldRequired);
		}
		
		Pool addedPool = this.poolDao.save(entity);
		
		return new SuccessDataResult<Pool>(addedPool, Messages.poolAdded);
	}

	@Override
	public DataResult<Pool> update(Pool entity) throws Exception {
		if(!this.poolDao.existsByPoolId(entity.getPoolId())) {
			throw new Exception();
		}
		
		Pool updatedPool = this.poolDao.save(entity);
		
		return new SuccessDataResult<Pool>(updatedPool, Messages.poolUpdated);
	}

	@Override
	public Result delete(Pool entity) throws Exception {
		this.poolDao.delete(entity);
		return new SuccessResult(Messages.poolDeleted);
	}

}
