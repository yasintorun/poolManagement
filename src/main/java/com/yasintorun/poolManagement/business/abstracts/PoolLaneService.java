package com.yasintorun.poolManagement.business.abstracts;

import com.yasintorun.poolManagement.entities.concretes.PoolLane;

public interface PoolLaneService extends CrudService<PoolLane>{

	int laneCount();

}
