package com.mobicartel.ale.properties.viewgroup;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

import com.mobicartel.ale.MainActivity;
import com.mobicartel.ale.properties.XmlSerializableProperty;
import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.Constants;
import com.mobicartel.ale.util.DimensionUtils;

public class LayoutParamsProperties {
	
	private final String PROP_WIDTH = "layout_width";
	private final String PROP_HEIGHT = "layout_height";
	private final String PROP_MARGIN_TOP = "layout_marginTop";
	private final String PROP_MARGIN_LEFT = "layout_marginLeft";
	private final String PROP_MARGIN_BOTTOM = "layout_marginBottom";
	private final String PROP_MARGIN_RIGHT = "layout_marginRight";
	
	
	public ArrayList<XmlSerializableProperty> list_properties;
	
	public Width width;
	public Height height;
	public MarginTop marginTop;
	public MarginLeft marginLeft;
	public MarginBottom marginBottom;
	public MarginRight marginRight;
	
	public LayoutParamsProperties() {
		
		list_properties = new ArrayList<XmlSerializableProperty>();
		width = new Width();
		height = new Height();
		marginTop = new MarginTop();
		marginLeft = new MarginLeft();
		marginBottom = new MarginBottom();
		marginRight = new MarginRight();
		list_properties.add(width);
		list_properties.add(height);
		list_properties.add(marginTop);
		list_properties.add(marginLeft);
		list_properties.add(marginBottom);
		list_properties.add(marginRight);
		
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
				throw new IllegalArgumentException("value of 'width' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
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
				throw new IllegalArgumentException("value of 'height' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class MarginTop extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_TOP;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			if (params == null) params = new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.topMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.topMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.topMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("NumberFormatException Occured");
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'marginTop' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class MarginLeft extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_LEFT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			if (params == null) params = new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.leftMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.leftMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.leftMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("NumberFormatException Occured");
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'marginLeft' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class MarginBottom extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_BOTTOM;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			if (params == null) params = new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.bottomMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.bottomMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.bottomMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("NumberFormatException Occured");
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'marginBottom' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class MarginRight extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_RIGHT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			if (params == null) params = new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.rightMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.rightMargin = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.rightMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("NumberFormatException Occured");
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.endsWith(Constants.UNIT_DIP) || value.endsWith(Constants.UNIT_DP) || value.endsWith(Constants.UNIT_PX)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'marginRight' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}

}
