package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.entities.concretes.PoolImage;

public interface PoolImageService extends CrudService<PoolImage>{
	DataResult<List<PoolImage>> getByPool_PoolId(int id);
	DataResult<PoolImage> getByPoolIdAndImageId(int poolId, int imageId);
}
