package com.mobicartel.ale.properties;

import android.view.View;


public interface XmlSerializableProperty {
	
	public String getName();
	public void setValue(String value) throws IllegalArgumentException;
	public String getValue();
	public String toXmlAttribute();
	public void updateView(View view) throws NullPointerException;

}
