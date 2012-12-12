package com.mobicartel.ale.object;

import android.content.res.Configuration;

import com.mobicartel.ale.util.DimensionUtils.Density;

public enum DeviceConfig {
	
	GALAXY_NEXUS(Density.XHDPI, 720, 1280, Configuration.ORIENTATION_PORTRAIT, "Galaxy Nexus");
	
	private Density density;
	private float screen_width;
	private float screen_height;
	private int orientation;
	private String name;
	
	DeviceConfig(Density density, float screen_width, float screen_height, int orientation, String name) {
		
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
	public float getScreenWidth() {
		return screen_width;
	}
	public void setScreenWidth(float screen_width) {
		this.screen_width = screen_width;
	}
	public float getScreenHeight() {
		return screen_height;
	}
	public void setScreenHeight(float screen_height) {
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
