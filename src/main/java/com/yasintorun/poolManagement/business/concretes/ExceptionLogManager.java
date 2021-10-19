package com.yasintorun.poolManagement.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.dataAccess.abstracts.ExceptionLogDao;
import com.yasintorun.poolManagement.entities.concretes.ExceptionLog;

@Service
public class ExceptionLogManager implements ExceptionLogService{
	private ExceptionLogDao exceptionLogDao;
	
	@Autowired
	public ExceptionLogManager(ExceptionLogDao exceptionLogDao) {
		super();
		this.exceptionLogDao = exceptionLogDao;
	}

	@Override
	public void log(ExceptionLog log) {
		try {
			this.exceptionLogDao.save(log);			
		} catch(Exception e) {
			
		}
	}
}
