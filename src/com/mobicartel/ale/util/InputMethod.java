package com.mobicartel.ale.util;

import com.mobicartel.ale.BasePropertyEditDialog;
import com.mobicartel.ale.DimensionDialog;

public enum InputMethod {
	
	DIMENSION(DimensionDialog.class);
	
	public Class<? extends BasePropertyEditDialog> clazz;
	
	InputMethod(Class<? extends BasePropertyEditDialog> clazz) {
		
		this.clazz = clazz;
		
	}

}
