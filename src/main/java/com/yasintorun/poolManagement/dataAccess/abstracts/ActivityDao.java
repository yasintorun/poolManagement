package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.Activity;

public interface ActivityDao extends JpaRepository<Activity, Integer>{

}
