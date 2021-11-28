package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.PoolImageService;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.PoolImageDao;
import com.yasintorun.poolManagement.entities.concretes.PoolImage;

import net.bytebuddy.asm.Advice.This;

@Service
public class PoolImageManager implements PoolImageService{
	private PoolImageDao poolImageDao;
	
	@Autowired
	public PoolImageManager(PoolImageDao poolImageDao) {
		super();
		this.poolImageDao = poolImageDao;
	}

	@Override
	public DataResult<List<PoolImage>> getAll() throws Exception {
		return new SuccessDataResult<List<PoolImage>>
		(this.poolImageDao.findAll(), "Havuz fotoğraf listesi");
	}

	@Override
	public DataResult<PoolImage> add(PoolImage entity) throws Exception {
		this.poolImageDao.save(entity);
		return new SuccessDataResult<PoolImage>("Eklendi");
	}

	@Override
	public DataResult<PoolImage> update(PoolImage entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(PoolImage entity) throws Exception {
		this.poolImageDao.delete(entity);
		return new SuccessResult("silindi");
	}

	@Override
	public DataResult<List<PoolImage>> getByPool_PoolId(int id) {
		return new SuccessDataResult<List<PoolImage>>
		(this.poolImageDao.getByPool_PoolId(id), "Havuza göre fotoğraflar listelendi");
	}

}
