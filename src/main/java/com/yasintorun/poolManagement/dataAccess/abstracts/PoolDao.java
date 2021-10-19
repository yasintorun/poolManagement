package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.Pool;

public interface PoolDao extends JpaRepository<Pool, Integer> {
	Pool getByPoolId(int poolId);
	boolean existsByPoolId(int poolId);
}
