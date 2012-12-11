package com.mobicartel.ale.util;


public class Verifier {
	
	public static boolean isBoolean(String value) {
		
		if (value.equals("true") || value.equals("false")) {
			return true;
		} 
		
		return false;
	}
	
	public static boolean isInteger(String value) {
		
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isColor(String value) {
		
		if (value.startsWith("#")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isColorResource(String value) {
		
		if (value.startsWith(Constants.COLOR_RESOURCES)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isDrawableResource(String value) {
		
		if (value.startsWith(Constants.DRAWABLE_RESOURCES)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isStringResource(String value) {
		
		if (value.startsWith(Constants.STRING_RESOURCES)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isGravity(String value) {
		
		if (value.equals("top") || value.equals("bottom") || value.equals("right") || 
				value.equals("left") || value.equals("center_vertical") || 
				value.equals("center_horizontal") || value.equals("center")) {
			return true;
		} 
		
		return false;
	}
	
	public static boolean isId(String value) {
		
		if (value.startsWith("@+id/")) {
			return true;
		} 
		return false;
	}
		
	public static boolean isDimension(String value) {
		
		if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
			return true;
		} 
		
		return false;
	}	

}
