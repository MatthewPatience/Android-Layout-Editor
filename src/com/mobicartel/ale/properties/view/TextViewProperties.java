package com.mobicartel.ale.properties.view;

import android.view.View;
import android.widget.TextView;

import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.ColorUtils;
import com.mobicartel.ale.util.Constants;
import com.mobicartel.ale.util.InputMethod;
import com.mobicartel.ale.util.Verifier;

public class TextViewProperties extends ViewProperties {

	private final String PROP_TEXT = "text";
	private final String PROP_TEXT_COLOR = "textColor";
	private final String PROP_GRAVITY = "gravity";
	
	public Text text;
	public TextColor text_color;
	public Gravity gravity;
	
	
	public TextViewProperties() {
		super();
		
		text = new Text();
		text_color = new TextColor();
		gravity = new Gravity();
		this.list_properties.add(text);
		this.list_properties.add(text_color);
		this.list_properties.add(gravity);
		
	}
	
	
	public class Text extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_TEXT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (Verifier.isStringResource(value)) {
				//FIXME: This needs to reference the string from the strings.xml file instead of just printing it out
				((TextView) view).setText(this.value);
			} else {
				((TextView) view).setText(this.value);
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
		@Override
		public InputMethod getInputMethod() {
			
			return null;
		}
	}
	
	public class TextColor extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_TEXT_COLOR;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (Verifier.isColor(value)) {
				((TextView) view).setTextColor(ColorUtils.getHexColorFromString(this.value));
			} else if (Verifier.isColorResource(value)) {
				((TextView) view).setTextColor(view.getContext().getResources().getIdentifier(this.value.substring(Constants.COLOR_RESOURCES.length()), Constants.TYPE_COLOR, view.getContext().getPackageName()));
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isColor(value) || Verifier.isColorResource(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be a hex color or a color resource");
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
	
	public class Gravity extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_GRAVITY;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.equals("top")) {
				((TextView) view).setGravity(android.view.Gravity.TOP);
			} else if (value.equals("bottom")) {
				((TextView) view).setGravity(android.view.Gravity.BOTTOM);
			} else if (value.equals("right")) {
				((TextView) view).setGravity(android.view.Gravity.RIGHT);
			} else if (value.equals("left")) {
				((TextView) view).setGravity(android.view.Gravity.LEFT);
			} else if (value.equals("center_vertical")) {
				((TextView) view).setGravity(android.view.Gravity.CENTER_VERTICAL);
			} else if (value.equals("center_horizontal")) {
				((TextView) view).setGravity(android.view.Gravity.CENTER_HORIZONTAL);
			} else if (value.equals("center")) {
				((TextView) view).setGravity(android.view.Gravity.CENTER);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isGravity(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must end one of 'top', 'bottom', 'right', 'left', 'center_vertical', 'center_horizontal', or 'center'");
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
