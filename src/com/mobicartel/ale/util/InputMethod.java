package com.mobicartel.ale.util;

import com.mobicartel.ale.BasePropertyEditDialog;
import com.mobicartel.ale.WidthHeightDialog;

public enum InputMethod {
	
	DIMENSION(WidthHeightDialog.class);
	
	public Class<? extends BasePropertyEditDialog> clazz;
	
	InputMethod(Class<? extends BasePropertyEditDialog> clazz) {
		
		this.clazz = clazz;
		
	}

}
