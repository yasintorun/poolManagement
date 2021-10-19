package com.yasintorun.poolManagement.core.crossCuttingConcerns.logging;

import com.yasintorun.poolManagement.business.abstracts.ExceptionLogService;
import com.yasintorun.poolManagement.entities.concretes.ExceptionLog;

public class DatabaseLogger implements ILogger{
	private ExceptionLogService exceptionLogService;

}
