package com.mobicartel.ale.util;

import com.mobicartel.ale.DimensionActivity;

public enum InputMethod {
	
	DIMENSION(DimensionActivity.class);
	
	public Class<?> clazz;
	
	InputMethod(Class<?> clazz) {
		
		this.clazz = clazz;
		
	}

}
