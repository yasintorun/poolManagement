package com.yasintorun.poolManagement.core.business.exceptions;

public class EntityNotFound extends Exception{

	private static String value = "Girilen entity değişkenine uygun veri bulunamadı.";
	
	public EntityNotFound() {
		super(value);
	}


	public EntityNotFound(String entityName) {
		super(value + " Entity: " + entityName);
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
