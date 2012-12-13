package com.mobicartel.ale.util;

import com.mobicartel.ale.*;

public enum InputMethod {
	
	WIDTH_HEIGHT(WidthHeightDialog.class),
	DIMENSION(DimensionDialog.class),
	BOOLEAN(BooleanDialog.class);
	
	public Class<? extends BasePropertyEditDialog> clazz;
	
	InputMethod(Class<? extends BasePropertyEditDialog> clazz) {
		
		this.clazz = clazz;
		
	}

}
