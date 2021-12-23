package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.ActivityContent;

public interface ActivityContentDao extends JpaRepository<ActivityContent, Integer> {

}
