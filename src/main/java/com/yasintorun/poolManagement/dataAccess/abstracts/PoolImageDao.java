package com.yasintorun.poolManagement.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.PoolImage;

public interface PoolImageDao extends JpaRepository<PoolImage, Integer> {
	List<PoolImage> getByPool_PoolId(int id);
}
