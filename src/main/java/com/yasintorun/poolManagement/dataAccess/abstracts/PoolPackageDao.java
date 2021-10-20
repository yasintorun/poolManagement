package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.PoolPackage;

public interface PoolPackageDao extends JpaRepository<PoolPackage, Integer>{
	PoolPackage getByPackageId(int packageId);
	boolean existsByPackageId(int packageId);
}
