package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.Pool;
import com.yasintorun.poolManagement.entities.dtos.PoolDto;

public interface PoolService extends CrudService<Pool> {
	DataResult<List<PoolDto>> getAllWithImages() throws Exception;
	int getPoolCount() throws Exception;
	Result uploadPoolImages(MultipartFile file, int poolId) throws Exception;
}
