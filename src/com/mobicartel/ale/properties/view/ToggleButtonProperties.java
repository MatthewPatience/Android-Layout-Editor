package com.mobicartel.ale.properties.view;

import android.view.View;
import android.widget.ToggleButton;

import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.Verifier;

public class ToggleButtonProperties extends CompoundButtonProperties {
	
	private final String PROP_TEXT_OFF = "textOff";
	private final String PROP_TEXT_ON = "textOn";
	
	public TextOff text_off;
	public TextOn text_on;
	
	public ToggleButtonProperties() {
		super();
		
		text_off = new TextOff();
		text_on = new TextOn();
		this.list_properties.add(text_off);
		this.list_properties.add(text_on);
		
	}
	
	public class TextOff extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_TEXT_OFF;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (Verifier.isStringResource(value)) {
				//FIXME: This needs to reference the string from the strings.xml file instead of just printing it out
				((ToggleButton) view).setText(this.value);
			} else {
				((ToggleButton) view).setText(this.value);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isStringResource(value)) {
				this.value = value;
				//FIXME: This needs to reference the string from the strings.xml file instead of just printing it out
			} else {
				this.value = value;
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class TextOn extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_TEXT_ON;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (Verifier.isStringResource(value)) {
				//FIXME: This needs to reference the string from the strings.xml file instead of just printing it out
				((ToggleButton) view).setText(this.value);
			} else {
				((ToggleButton) view).setText(this.value);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isStringResource(value)) {
				this.value = value;
				//FIXME: This needs to reference the string from the strings.xml file instead of just printing it out
			} else {
				this.value = value;
			}
		}
		public String getValue() {
			return value;
		}
	}

}
