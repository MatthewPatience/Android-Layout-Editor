package com.mobicartel.ale.util;

public class DimensionUtils {
	
	public enum Density {
		
		LDPI (0.75f),
		MDPI (1.0f),
		HDPI (1.5f),
		XHDPI (2.0f);
		
		
		public float conversion;
		
		Density(float conversion) {
			this.conversion = conversion;
		}
		
	}

	public static int convertToDensity(int density_dpi, int size) {
		
		return (int) (size * density_dpi);
	}
	
}
