package com.mobicartel.ale.properties.view;

import java.util.ArrayList;

import android.view.View;

import com.mobicartel.ale.MainActivity;
import com.mobicartel.ale.properties.XmlSerializableProperty;
import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;
import com.mobicartel.ale.util.ColorUtils;
import com.mobicartel.ale.util.Constants;
import com.mobicartel.ale.util.DimensionUtils;
import com.mobicartel.ale.util.Verifier;

public class ViewProperties {
	
	private final String PROP_BACKGROUND = "background";
	private final String PROP_ID = "id";
	private final String PROP_PADDING_TOP = "paddingTop";
	private final String PROP_PADDING_LEFT = "paddingLeft";
	private final String PROP_PADDING_BOTTOM = "paddingBottom";
	private final String PROP_PADDING_RIGHT = "paddingRight";
	private final String PROP_PADDING = "padding";
	
	public ArrayList<XmlSerializableProperty> list_properties;
	
	public Background background;
	public Id id;
	public PaddingTop padding_top;
	public PaddingLeft padding_left;
	public PaddingBottom padding_bottom;
	public PaddingRight padding_right;
	public Padding padding;
	
	
	public ViewProperties() {
		
		list_properties = new ArrayList<XmlSerializableProperty>();
		
		background = new Background();
		id = new Id();
		padding_top = new PaddingTop();
		padding_left = new PaddingLeft();
		padding_bottom = new PaddingBottom();
		padding_right = new PaddingRight();
		padding = new Padding();
		list_properties.add(background);
		list_properties.add(id);
		list_properties.add(padding_top);
		list_properties.add(padding_left);
		list_properties.add(padding_bottom);
		list_properties.add(padding_right);
		list_properties.add(padding);
		
	}
	
	
	public class Background extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_BACKGROUND;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (Verifier.isColor(value)) {
				view.setBackgroundColor(ColorUtils.getHexColorFromString(this.value));
			} else if (Verifier.isDrawableResource(value)) {
				view.setBackgroundResource(view.getContext().getResources().getIdentifier(
						this.value.substring(Constants.DRAWABLE_RESOURCES.length()), 
						Constants.TYPE_DRAWABLE, 
						view.getContext().getPackageName()));
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isColor(value) || Verifier.isDrawableResource(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must be a hex color or a drawable resource");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class Id extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_ID;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (Verifier.isId(value)) {
				view.setId(this.value.replace("@+id/", "").hashCode());
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isId(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must start with @+id/");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class PaddingTop extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_PADDING_TOP;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.endsWith(Constants.UNIT_DIP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				view.setPadding(view.getPaddingLeft(), size, view.getPaddingRight(), view.getPaddingBottom());
			} else if (value.endsWith(Constants.UNIT_DP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				view.setPadding(view.getPaddingLeft(), size, view.getPaddingRight(), view.getPaddingBottom());
			} else if (value.endsWith(Constants.UNIT_PX)) {
				view.setPadding(view.getPaddingLeft(), Integer.valueOf(value.replace(Constants.UNIT_PX, "")), view.getPaddingRight(), view.getPaddingBottom());
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isDimension(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class PaddingLeft extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_PADDING_LEFT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.endsWith(Constants.UNIT_DIP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				view.setPadding(size, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
			} else if (value.endsWith(Constants.UNIT_DP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				view.setPadding(size, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
			} else if (value.endsWith(Constants.UNIT_PX)) {
				view.setPadding(Integer.valueOf(value.replace(Constants.UNIT_PX, "")), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isDimension(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class PaddingBottom extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_PADDING_BOTTOM;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.endsWith(Constants.UNIT_DIP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), size);
			} else if (value.endsWith(Constants.UNIT_DP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), size);
			} else if (value.endsWith(Constants.UNIT_PX)) {
				view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), Integer.valueOf(value.replace(Constants.UNIT_PX, "")));
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isDimension(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class PaddingRight extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_PADDING_RIGHT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.endsWith(Constants.UNIT_DIP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), size, view.getPaddingBottom());
			} else if (value.endsWith(Constants.UNIT_DP)) {
				int size = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), size, view.getPaddingBottom());
			} else if (value.endsWith(Constants.UNIT_PX)) {
				view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), Integer.valueOf(value.replace(Constants.UNIT_PX, "")), view.getPaddingBottom());
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isDimension(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class Padding extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_PADDING;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			if (value.endsWith(Constants.UNIT_DIP)) {
				int padding = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DIP, "")));
				view.setPadding(padding, padding, padding, padding);
			} else if (value.endsWith(Constants.UNIT_DP)) {
				int padding = DimensionUtils.convertToDensity(MainActivity.device_config.getDensity(), Integer.valueOf(value.replace(Constants.UNIT_DP, "")));
				view.setPadding(padding, padding, padding, padding);
			} else if (value.endsWith(Constants.UNIT_PX)) {
				int padding = Integer.valueOf(value.replace(Constants.UNIT_PX, ""));
				view.setPadding(padding, padding, padding, padding);
			}
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (Verifier.isDimension(value)) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of '" + NAME + "' must end with a unit of measurement");
			}
		}
		public String getValue() {
			return value;
		}
	}

}
