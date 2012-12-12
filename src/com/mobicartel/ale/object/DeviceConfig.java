package com.mobicartel.ale.object;

import android.content.res.Configuration;

import com.mobicartel.ale.util.DimensionUtils.Density;

public enum DeviceConfig {
	
	GALAXY_NEXUS(Density.XHDPI, 720, 1280, Configuration.ORIENTATION_PORTRAIT, "Galaxy Nexus");
	
	private Density density;
	private int screen_width;
	private int screen_height;
	private int orientation;
	private String name;
	
	DeviceConfig(Density density, int screen_width, int screen_height, int orientation, String name) {
		
		this.density = density;
		this.screen_width = screen_width;
		this.screen_height = screen_height;
		this.orientation = orientation;
		this.name = name;
		
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
