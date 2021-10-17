package com.yasintorun.poolManagement.core.business;

import com.yasintorun.poolManagement.core.utilities.results.Result;

public class BusinessRules {
	public static Result Run(Result...results) {
		for(Result result : results) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return null;
	}
}
