package com.mobicartel.ale.properties.params;


import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.InputMethod;

import android.view.View;
import android.widget.LinearLayout;

public class LinearLayoutParamsProperties extends MarginLayoutParamsProperties {
	
	private final String PROP_GRAVITY = "layout_gravity";
	private final String PROP_WEIGHT = "layout_weight";
	
	public Gravity gravity;
	public Weight weight;
	
	public LinearLayoutParamsProperties() {
		super();
		
		gravity = new Gravity();
		weight = new Weight();
		this.list_properties.add(gravity);
		this.list_properties.add(weight);
		
	}
	
	public class Gravity extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_GRAVITY;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("top")) {
				params.gravity = android.view.Gravity.TOP;
			} else if (value.equals("bottom")) {
				params.gravity = android.view.Gravity.BOTTOM;
			} else if (value.equals("right")) {
				params.gravity = android.view.Gravity.RIGHT;
			} else if (value.equals("left")) {
				params.gravity = android.view.Gravity.LEFT;
			} else if (value.equals("center_vertical")) {
				params.gravity = android.view.Gravity.CENTER_VERTICAL;
			} else if (value.equals("center_horizontal")) {
				params.gravity = android.view.Gravity.CENTER_HORIZONTAL;
			} else if (value.equals("center")) {
				params.gravity = android.view.Gravity.CENTER;
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("top") || value.equals("bottom") || value.equals("right") || 
					value.equals("left") || value.equals("center_vertical") || 
					value.equals("center_horizontal") || value.equals("center")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of " + NAME + " must end one of 'top', 'bottom', 'right', 'left', 'center_vertical', 'center_horizontal', 'center', ");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return null;
		}
	}
	
	public class Weight extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_WEIGHT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
			params.weight = Float.parseFloat(value);
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			try {
				Float.parseFloat(value);
				this.value = value;
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("value of " + NAME + " must be a float");
			}
		}
		public String getValue() {
			return value;
		}
		@Override
		public InputMethod getInputMethod() {
			
			return null;
		}
	}

}
