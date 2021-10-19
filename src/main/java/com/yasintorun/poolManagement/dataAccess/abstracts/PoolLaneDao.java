package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.PoolLane;

public interface PoolLaneDao extends JpaRepository<PoolLane, Integer>{
	boolean existsByLaneId(int poolLaneId);
}
