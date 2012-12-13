package com.mobicartel.ale.object;

import android.content.res.Configuration;
import android.util.DisplayMetrics;

import com.mobicartel.ale.util.DimensionUtils.Density;

public enum DeviceConfig {
	
	GALAXY_NEXUS(Density.XHDPI.conversion, 2.0f, DisplayMetrics.DENSITY_XHIGH, 315, 319, 720, 1280, Configuration.ORIENTATION_PORTRAIT, "Galaxy Nexus"),
	NEXUS_ONE(Density.HDPI.conversion, 1.5f, DisplayMetrics.DENSITY_HIGH, 254, 254, 480, 800, Configuration.ORIENTATION_PORTRAIT, "Nexus One");
	
	private DisplayMetrics metrics;
	private int orientation;
	private String name;
	
	DeviceConfig(float density_conversion, float scaled_density, int density_dpi, float xdpi, float ydpi, int screen_width, int screen_height, int orientation, String name) {
		
		metrics = new DisplayMetrics();
		metrics.density = density_conversion;
		metrics.densityDpi = density_dpi;
		metrics.xdpi = xdpi;
		metrics.ydpi = ydpi;
		metrics.widthPixels = screen_width;
		metrics.heightPixels = screen_height;
		metrics.scaledDensity = scaled_density;
		this.orientation = orientation;
		this.name = name;
		
	}
	
	
	public DisplayMetrics getDisplayMetrics() {
		return metrics;
	}
	public void setDisplayMetrics(DisplayMetrics metrics) {
		this.metrics = metrics;
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
