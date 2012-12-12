package com.mobicartel.ale;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.properties.XmlSerializableProperty;

public abstract class BasePropertyEditDialog extends Dialog {
	
	private XmlSerializableProperty property;
	private Component component;
	
	public BasePropertyEditDialog(Context context, XmlSerializableProperty property, Component component) {
		super(context);
		
		this.property = property;
		this.component = component;
		
	}
	
	public void setPropertyValue(String value) {
		try {
			property.setValue(value);
			property.updateView(component.getView());
			component.getView().invalidate();
		} catch (IllegalArgumentException e) {
			if (e.getMessage() != null) {
				Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getContext(), "Invalid Property", Toast.LENGTH_SHORT).show();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			Toast.makeText(getContext(), "An Error Occured", Toast.LENGTH_SHORT).show();
		}
		
	}

	public XmlSerializableProperty getProperty() {
		return property;
	}

	public void setProperty(XmlSerializableProperty property) {
		this.property = property;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

}
