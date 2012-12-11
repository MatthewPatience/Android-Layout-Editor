package com.mobicartel.ale.properties.view;

import android.view.View;
import android.widget.CompoundButton;

import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.Constants;
import com.mobicartel.ale.util.Verifier;

public class CompoundButtonProperties extends ViewProperties {
	
	private final String PROP_CHECKED = "checked";
	private final String PROP_BUTTON = "button";
	
	public Checked checked;
	public Button button;
	
	public CompoundButtonProperties() {
		super();
		
		checked = new Checked();
		button = new Button();
		this.list_properties.add(checked);
		this.list_properties.add(button);
		
	}
	
	public class Checked extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_CHECKED;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.equals("true")) {
				((CompoundButton) view).setChecked(true);
			} else {
				((CompoundButton) view).setChecked(false);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isBoolean(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class Button extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_BUTTON;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			((CompoundButton) view).setButtonDrawable(view.getContext().getResources().getIdentifier(
					this.value.substring(Constants.DRAWABLE_RESOURCES.length()), 
					Constants.TYPE_DRAWABLE, 
					view.getContext().getPackageName()));
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isDrawableResource(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be a drawable resource");
			}
		}
		public String getValue() {
			return value;
		}
	}

}
