package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.PoolPackageService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.exceptions.EntityNotFound;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.PoolPackageDao;
import com.yasintorun.poolManagement.entities.concretes.PoolPackage;

@Service
public class PoolPackageManager implements PoolPackageService{
	private PoolPackageDao poolPackageDao;

	@Autowired
	public PoolPackageManager(PoolPackageDao poolPackageDao) {
		super();
		this.poolPackageDao = poolPackageDao;
	}

	@Override
	public DataResult<List<PoolPackage>> getAll() throws Exception {
		Sort sort = Sort.by(Sort.Direction.ASC, "packageId");
		return new SuccessDataResult<List<PoolPackage>>(this.poolPackageDao.findAll(sort), Messages.poolPackageListed);
	}

	@Override
	public DataResult<PoolPackage> add(PoolPackage entity) throws Exception {
		if(entity.getPackagePrice() < 0) {
			return new ErrorDataResult<PoolPackage>(Messages.poolPackagePriceNotLessThanZero);
		}
		
		PoolPackage addedPackage = this.poolPackageDao.save(entity);
		
		return new SuccessDataResult<PoolPackage>(addedPackage, Messages.poolPackageAdded);
	}

	@Override
	public DataResult<PoolPackage> update(PoolPackage entity) throws Exception {
		if(!this.poolPackageDao.existsByPackageId(entity.getPackageId())) {
			throw new EntityNotFound("PoolPackage");
		}
		
		if(entity.getPackagePrice() < 0) {
			return new ErrorDataResult<PoolPackage>(Messages.poolPackagePriceNotLessThanZero);
		}
		
		PoolPackage updatedPackage = this.poolPackageDao.save(entity);
		
		return new SuccessDataResult<PoolPackage>(updatedPackage, Messages.poolPackageUpdated);
	}

	@Override
	public Result delete(PoolPackage entity) throws Exception {
		if(!this.poolPackageDao.existsByPackageId(entity.getPackageId())) {
			throw new EntityNotFound("PoolPackage");
		}
		this.poolPackageDao.delete(entity);
		
		return new SuccessResult(Messages.poolPackageDeleted);
	}

	@Override
	public int poolPackageCount() {
		return this.poolPackageDao.findAll().size();
	}
	
	
	
}
