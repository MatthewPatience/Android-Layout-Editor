package com.mobicartel.ale.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.properties.view.ButtonProperties;
import com.mobicartel.ale.properties.view.CompoundButtonProperties.Checked;
import com.mobicartel.ale.properties.view.TextViewProperties;
import com.mobicartel.ale.properties.view.TextViewProperties.Text;
import com.mobicartel.ale.properties.view.ToggleButtonProperties;

public class DefaultComponentCreator {
	
	public static Component createViewComponent(Context context) {
		
		View view = new View(context);
		view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		Component component = new Component(view);
		
		return component;
	}
	
	public static Component createTextViewComponent(Context context) {
		
		TextView textview = new TextView(context);
		textview.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		Component component = new Component(textview);
		final Text text = ((TextViewProperties) component.getViewProps()).text;
		text.setValue("TextView");
		text.updateView(textview);
		
		return component;
	}
	
	public static Component createButtonComponent(Context context) {
		
		Button button = new Button(context);
		button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		Component component = new Component(button);
		final Text text = ((ButtonProperties) component.getViewProps()).text;
		text.setValue("Button");
		text.updateView(button);
		
		return component;
	}
	
	public static Component createToggleButtonComponent(Context context) {
		
		ToggleButton togglebutton = new ToggleButton(context);
		togglebutton.setChecked(true);
		togglebutton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		Component component = new Component(togglebutton);
		final Checked checked = ((ToggleButtonProperties) component.getViewProps()).checked;
		checked.setValue("true");
		checked.updateView(togglebutton);
		
		return component;
	}
	
	public static Component createProgressBarComponent(Context context) {
		
		ProgressBar progressbar = new ProgressBar(context);
		progressbar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		Component component = new Component(progressbar);
		
		return component;
	}

}
