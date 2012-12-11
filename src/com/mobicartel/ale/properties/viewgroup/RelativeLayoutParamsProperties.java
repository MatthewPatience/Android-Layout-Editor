package com.mobicartel.ale.properties.viewgroup;


import com.mobicartel.ale.properties.XmlSerializablePropertyAbsImpl;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class RelativeLayoutParamsProperties extends MarginLayoutParamsProperties {
	
	private final String PROP_ALIGN_PARENT_TOP = "layout_alignParentTop";
	private final String PROP_ALIGN_PARENT_LEFT = "layout_alignParentLeft";
	private final String PROP_ALIGN_PARENT_BOTTOM = "layout_alignParentBottom";
	private final String PROP_ALIGN_PARENT_RIGHT = "layout_alignParentRight";
	private final String PROP_CENTER_HORIZONTAL = "layout_centerHorizontal";
	private final String PROP_CENTER_VERTICAL = "layout_centerVertical";
	private final String PROP_CENTER_IN_PARENT = "layout_centerInParent";
	
	public AlignParentTop align_parent_top;
	public AlignParentLeft align_parent_left;
	public AlignParentBottom align_parent_bottom;
	public AlignParentRight align_parent_right;
	public CenterHorizontal center_horizontal;
	public CenterVertical center_vertical;
	public CenterInParent center_in_parent;
	//TODO: Add all of the ID related alignments
	
	public RelativeLayoutParamsProperties() {
		super();
		
		align_parent_top = new AlignParentTop();
		align_parent_left = new AlignParentLeft();
		align_parent_bottom = new AlignParentBottom();
		align_parent_right = new AlignParentRight();
		center_horizontal = new CenterHorizontal();
		center_vertical = new CenterVertical();
		center_in_parent = new CenterInParent();
		this.list_properties.add(align_parent_top);
		this.list_properties.add(align_parent_left);
		this.list_properties.add(align_parent_bottom);
		this.list_properties.add(align_parent_right);
		this.list_properties.add(center_horizontal);
		this.list_properties.add(center_vertical);
		this.list_properties.add(center_in_parent);
		
	}
	
	public class AlignParentTop extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_ALIGN_PARENT_TOP;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_alignParentTop' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class AlignParentLeft extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_ALIGN_PARENT_LEFT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_alignParentLeft' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class AlignParentBottom extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_ALIGN_PARENT_BOTTOM;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_alignParentBottom' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class AlignParentRight extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_ALIGN_PARENT_RIGHT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_alignParentRight' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class CenterHorizontal extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_CENTER_HORIZONTAL;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.CENTER_HORIZONTAL);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_centerHorizontal' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class CenterVertical extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_CENTER_VERTICAL;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.CENTER_VERTICAL);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_centerVertical' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}
	
	public class CenterInParent extends XmlSerializablePropertyAbsImpl {
		private final String NAME = PROP_CENTER_IN_PARENT;
		private String value;
		public String getName() {
			return NAME;
		}
		public void updateView(View view) throws NullPointerException {
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
			if (value.equals("true")) {
				params.addRule(RelativeLayout.CENTER_IN_PARENT);
			} else if (value.equals("false")) {
				//TODO: Figure out how to get rid of alignment
			}
			view.setLayoutParams(params);
		}
		public void setValue(String value) throws IllegalArgumentException {
			if (value.equals("true") || value.equals("false")) {
				this.value = value;
			} else {
				throw new IllegalArgumentException("value of 'layout_centerInParent' must be one of 'true' or 'false'");
			}
		}
		public String getValue() {
			return value;
		}
	}

}
