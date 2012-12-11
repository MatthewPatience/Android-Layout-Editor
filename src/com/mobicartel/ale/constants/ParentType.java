package com.mobicartel.ale.constants;

import java.lang.reflect.InvocationTargetException;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mobicartel.ale.properties.viewgroup.LayoutParamsProperties;
import com.mobicartel.ale.properties.viewgroup.LinearLayoutParamsProperties;
import com.mobicartel.ale.properties.viewgroup.RelativeLayoutParamsProperties;

public enum ParentType {

	LINEAR ("LinearLayout", LinearLayout.class), 
	RELATIVE ("RelativeLayout", RelativeLayout.class), 
	FRAME ("FrameLayout", FrameLayout.class);
	
	public final String title;
	public final Class<? extends ViewGroup> view;
	
	ParentType(String title, Class<? extends ViewGroup> view) {
		this.title = title;
		this.view = view;
	}
	
	public LayoutParamsProperties getProperties() {
		
		LayoutParamsProperties properties;
		
		if (view == LinearLayout.class) {
			properties = new LinearLayoutParamsProperties();
			setPropertyDefaults(properties);
			return properties;
		} else if (view == RelativeLayout.class) {
			properties = new RelativeLayoutParamsProperties();
			setPropertyDefaults(properties);
			return properties;
		} else if (view == FrameLayout.class) {
			properties = new LayoutParamsProperties();
			setPropertyDefaults(properties);
			return properties;
		} else {
			properties = new LayoutParamsProperties();
			setPropertyDefaults(properties);
			return properties;
		}
		
	}
	
	private void setPropertyDefaults(LayoutParamsProperties properties) {
		properties.height.setValue("wrap_content");
		properties.width.setValue("wrap_content");
	}
	
	private void setLayoutParamsDefaults(LayoutParams params) {
		params.width = LayoutParams.WRAP_CONTENT;
		params.height = LayoutParams.WRAP_CONTENT;
	}
	
	public ViewGroup getViewGroup(Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
		
		return (ViewGroup) Class.forName(((Class<ViewGroup>) view).getName()).getDeclaredConstructors()[0].newInstance(context);
	}
	
	public LayoutParams getLayoutParams() {
		
		if (view == LinearLayout.class) {
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, 0);
			setLayoutParamsDefaults(params);
			return params;
		} else if (view == RelativeLayout.class) {
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
			setLayoutParamsDefaults(params);
			return params;
		} else if (view == FrameLayout.class) {
			ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(0, 0);
			setLayoutParamsDefaults(params);
			return params;
		} else {
			ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(0, 0);
			setLayoutParamsDefaults(params);
			return params;
		}
		
	}

}
