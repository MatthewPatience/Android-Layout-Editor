package com.mobicartel.ale.properties.viewgroup;



import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.properties.view.ViewProperties;
import com.mobicartel.ale.util.InputMethod;

import android.view.View;
import android.widget.LinearLayout;

public class LinearLayoutProperties extends ViewProperties {
	
	private final String PROP_ORIENTATION = "orientation";
	
	public Orientation orientation;
	
	public LinearLayoutProperties() {
		super();
		
		orientation = new Orientation();
		orientation.setValue("vertical");
		this.list_properties.add(orientation);
		
	}
	
	public class Orientation extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_ORIENTATION;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.equals("vertical")) {
				((LinearLayout) view).setOrientation(LinearLayout.VERTICAL);
			} else if (value.equals("horizontal")) {
				((LinearLayout) view).setOrientation(LinearLayout.HORIZONTAL);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("vertical") || value.equals("horizontal")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of " + NAME + " must end either 'vertical' or 'horizontal'");
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
