package com.mobicartel.ale.constants;

import java.lang.reflect.InvocationTargetException;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.properties.view.ButtonProperties;
import com.mobicartel.ale.properties.view.LinearLayoutProperties;
import com.mobicartel.ale.properties.view.ProgressBarProperties;
import com.mobicartel.ale.properties.view.TextViewProperties;
import com.mobicartel.ale.properties.view.ToggleButtonProperties;
import com.mobicartel.ale.properties.view.ViewProperties;
import com.mobicartel.ale.util.DefaultComponentCreator;

public enum ViewType {
	
	TOGGLE_BUTTON ("ToggleButton", ToggleButton.class, false, new ToggleButtonProperties()), 
	BUTTON ("Button", Button.class, false, new ButtonProperties()), //extends TextView
	TEXTVIEW ("TextView", TextView.class, false, new TextViewProperties()), 
	PROGRESS_BAR ("ProgressBar", ProgressBar.class, false, new ProgressBarProperties()), 
	LINEAR_LAYOUT ("LinearLayout", LinearLayout.class, true, new LinearLayoutProperties()), 
	RELATIVE_LAYOUT ("RelativeLayout", RelativeLayout.class, true, new ViewProperties()), 
	FRAME_LAYOUT ("FrameLayout", FrameLayout.class, true, new ViewProperties()),
	VIEW ("View", View.class, false, new ViewProperties());
	
	public final String title;
	public final Class<?> view;
	public boolean viewgroup;
	public ViewProperties props;
	
	ViewType(String title, Class<?> view, boolean viewgroup, ViewProperties props) {
		
		this.title = title;
		this.view = view;
		this.viewgroup = viewgroup;
		this.props = props;
		
	}
	
	public static ViewType getViewType(String type) {
		
		final ViewType[] types = ViewType.values();
		for (int i = 0; i < types.length; i++) {
			if (type.equals(types[i].name())) {
				return types[i];
			}
		}
		
		return null;
	}
	
	public Component getComponent(Context context) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		
		Component component = null;
		
		if (view == ToggleButton.class) {
			component = DefaultComponentCreator.createToggleButtonComponent(context);
		} else if (view == Button.class) {
			component = DefaultComponentCreator.createButtonComponent(context);
		} else if (view == TextView.class) {
			component = DefaultComponentCreator.createTextViewComponent(context);
		} else if (view == ProgressBar.class) {
			component = DefaultComponentCreator.createProgressBarComponent(context);
		} else {
			component = new Component((View) Class.forName(((Class<View>) view).getName()).getDeclaredConstructors()[0].newInstance(context));
		}
		
		return component;
	}

}
