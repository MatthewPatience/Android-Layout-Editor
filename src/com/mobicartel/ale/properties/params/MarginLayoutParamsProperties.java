package com.mobicartel.ale.properties.params;


import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.Constants;
import com.mobicartel.ale.util.InputMethod;

public class MarginLayoutParamsProperties extends LayoutParamsProperties {
	
	private final String PROP_MARGIN_TOP = "layout_marginTop";
	private final String PROP_MARGIN_LEFT = "layout_marginLeft";
	private final String PROP_MARGIN_BOTTOM = "layout_marginBottom";
	private final String PROP_MARGIN_RIGHT = "layout_marginRight";
	
	public MarginTop margin_top;
	public MarginLeft margin_left;
	public MarginBottom margin_bottom;
	public MarginRight margin_right;
	
	public MarginLayoutParamsProperties() {
		super();
		
		margin_top = new MarginTop();
		margin_left = new MarginLeft();
		margin_bottom = new MarginBottom();
		margin_right = new MarginRight();
		this.list_properties.add(margin_top);
		this.list_properties.add(margin_left);
		this.list_properties.add(margin_bottom);
		this.list_properties.add(margin_right);
		
	}
	
	public class MarginTop extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_TOP;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.topMargin = Integer.valueOf(value.replace(Constants.UNIT_DIP, ""));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.topMargin = Integer.valueOf(value.replace(Constants.UNIT_DP, ""));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.topMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
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
			} else {
				throw new IllegalArgumentException("value of 'layout_marginTop' must end with a unit of measurement");
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
	
	public class MarginLeft extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_LEFT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.leftMargin = Integer.valueOf(value.replace(Constants.UNIT_DIP, ""));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.leftMargin = Integer.valueOf(value.replace(Constants.UNIT_DP, ""));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.leftMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
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
			} else {
				throw new IllegalArgumentException("value of 'layout_marginLeft' must end with a unit of measurement");
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
	
	public class MarginBottom extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_BOTTOM;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.bottomMargin = Integer.valueOf(value.replace(Constants.UNIT_DIP, ""));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.bottomMargin = Integer.valueOf(value.replace(Constants.UNIT_DP, ""));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.bottomMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
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
			} else {
				throw new IllegalArgumentException("value of 'layout_marginBottom' must end with a unit of measurement");
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
	
	public class MarginRight extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_MARGIN_RIGHT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
			try {
				if (value.endsWith(Constants.UNIT_DIP)) {
					params.rightMargin = Integer.valueOf(value.replace(Constants.UNIT_DIP, ""));
				} else if (value.endsWith(Constants.UNIT_DP)) {
					params.rightMargin = Integer.valueOf(value.replace(Constants.UNIT_DP, ""));
				} else if (value.endsWith(Constants.UNIT_PX)) {
					params.rightMargin = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
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
			} else {
				throw new IllegalArgumentException("value of 'layout_marginRight' must end with a unit of measurement");
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
