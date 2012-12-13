package com.mobicartel.ale.util;

import com.mobicartel.ale.BasePropertyEditDialog;
import com.mobicartel.ale.DimensionDialog;
import com.mobicartel.ale.WidthHeightDialog;

public enum InputMethod {
	
	WIDTH_HEIGHT(WidthHeightDialog.class),
	DIMENSION(DimensionDialog.class);
	
	public Class<? extends BasePropertyEditDialog> clazz;
	
	InputMethod(Class<? extends BasePropertyEditDialog> clazz) {
		
		this.clazz = clazz;
		
	}

}
