package com.mobicartel.ale.object;

import com.mobicartel.ale.util.DimensionUtils.Density;

public class DeviceConfig {
	
	public static final int PORTRAIT = 0;
	public static final int LANDSCAPE = 1;
	
	private Density density;
	private int screen_width;
	private int screen_height;
	private int orientation;
	
	public DeviceConfig() {
		
	}
	
	public DeviceConfig(Density density, int screen_width, int screen_height, int orientation) {
		
		this.density = density;
		this.screen_width = screen_width;
		this.screen_height = screen_height;
		this.orientation = orientation;
		
	}
	
	
	public Density getDensity() {
		return density;
	}
	public void setDensity(Density density) {
		this.density = density;
	}
	public int getScreenWidth() {
		return screen_width;
	}
	public void setScreenWidth(int screen_width) {
		this.screen_width = screen_width;
	}
	public int getScreenHeight() {
		return screen_height;
	}
	public void setScreenHeight(int screen_height) {
		this.screen_height = screen_height;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

}
