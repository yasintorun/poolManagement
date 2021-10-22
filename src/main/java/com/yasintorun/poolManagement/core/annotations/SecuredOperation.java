package com.yasintorun.poolManagement.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface SecuredOperation {
	public String[] claims();
}
