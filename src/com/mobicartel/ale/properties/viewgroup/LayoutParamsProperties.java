package com.mobicartel.ale.properties.viewgroup;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.mobicartel.ale.MainActivity;
import com.mobicartel.ale.properties.XmlSerializableProperty;
import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.Constants;
import com.mobicartel.ale.util.DimensionUtils;
import com.mobicartel.ale.util.InputMethod;

public class LayoutParamsProperties {
	
	private final String PROP_WIDTH = "layout_width";
	private final String PROP_HEIGHT = "layout_height";
	
	
	public ArrayList<XmlSerializableProperty> list_properties;
	
	public Width width;
	public Height height;
	
	public LayoutParamsProperties() {
		
		list_properties = new ArrayList<XmlSerializableProperty>();
		width = new Width();
		height = new Height();
		list_properties.add(width);
		list_properties.add(height);
		
	}
	
	
	
	public class Width extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_WIDTH;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			LayoutParams params = view.getLayoutParams();
			if (params == null) params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.width = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.width = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.width = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				} else if (value.equals("wrap_content")) {
					params.width = LayoutParams.WRAP_CONTENT;
				} else if (value.equals("match_parent")) {
					params.width = LayoutParams.MATCH_PARENT;
				} else if (value.equals("fill_parent")) {
					params.width = LayoutParams.MATCH_PARENT;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new IllegalArgumentException();
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
				this.value = value;
			} else if (value.equals("wrap_content") || value.equals("match_parent") || value.equals("fill_parent")){
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of " + NAME + " must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return InputMethod.DIMENSION;
		}
	}
	
	public class Height extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_HEIGHT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			LayoutParams params = view.getLayoutParams();
			if (params == null) params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.height = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.height = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.height = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				} else if (value.equals("wrap_content")) {
					params.height = LayoutParams.WRAP_CONTENT;
				} else if (value.equals("match_parent")) {
					params.height = LayoutParams.MATCH_PARENT;
				} else if (value.equals("fill_parent")) {
					params.height = LayoutParams.MATCH_PARENT;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new IllegalArgumentException();
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
				this.value = value;
			} else if (value.equals("wrap_content") || value.equals("match_parent") || value.equals("fill_parent")){
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of " + NAME + " must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return InputMethod.DIMENSION;
		}
	}

}
