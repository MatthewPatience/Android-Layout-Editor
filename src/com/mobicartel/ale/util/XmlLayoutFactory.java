package com.mobicartel.ale.util;

import java.io.StringWriter;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.util.Log;
import android.util.Xml;

import com.mobicartel.ale.object.Component;
import com.mobicartel.ale.properties.XmlSerializableProperty;
import com.mobicartel.ale.properties.params.LayoutParamsProperties;
import com.mobicartel.ale.properties.view.ViewProperties;

public class XmlLayoutFactory {
	
	private static StringWriter writer = new StringWriter();
	private static XmlSerializer serializer = Xml.newSerializer();
	
	public static String writeXml(Component component) throws XmlPullParserException {
		
	    serializer = Xml.newSerializer();
	    writer = new StringWriter();
	    try {
	        serializer.setOutput(writer);
	        Log.v("ALE", "START DOCUMENT");
	        serializer.startDocument("UTF-8", true);
	        
	        //Print Root Tag
	        Log.v("ALE", "START TAG: " + component.getViewType().title);
	        serializer.startTag("", component.getViewType().title);
	        //Declare Namespace
	        Log.v("ALE", "Attribute: " + "xmlns:android" + "=" + "http://schemas.android.com/apk/res/android");
	        serializer.attribute("", "xmlns:android", "http://schemas.android.com/apk/res/android");
	        
	        printComponentAttributes(component);
	        
	        //Print Children of Root(the Corn)
	        ArrayList<Component> list_children = component.getListChildren();
	        for (Component child : list_children) {
	        	printComponent(child);
	        }
	        
	        
	        Log.v("ALE", "END TAG: " + component.getViewType().title);
	        serializer.endTag("", component.getViewType().title);
	        
	        Log.v("ALE", "END DOCUMENT");
	        serializer.endDocument();
	        
	        return writer.toString();
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	        throw new XmlPullParserException("unable to create xml layout document");
	    } 
	    
	}
	
	private static void printComponent(Component component) throws Exception {
		
		Log.v("ALE", "START TAG: " + component.getViewType().title);
		serializer.startTag("", component.getViewType().title);
		
		printComponentAttributes(component);
		
		//Print Children Recursively
		ArrayList<Component> list_children = component.getListChildren();
		if (list_children.size() != 0) {
	        for (Component child : list_children) {
	        	printComponent(child);
	        }
		}
		
		Log.v("ALE", "END TAG: " + component.getViewType().title);
        serializer.endTag("", component.getViewType().title);
		
	}
	
	private static void printComponentAttributes(Component component) throws Exception {
		
		ViewProperties view_props = component.getViewProps();
		
		for (int i = 0; i < view_props.list_properties.size(); i++) {
			XmlSerializableProperty property = view_props.list_properties.get(i);
			if (property.getValue() != null) {
				Log.v("ALE", "Attribute: " + property.toXmlAttribute() + "=" + property.getValue());
				serializer.attribute("", property.toXmlAttribute(), property.getValue());
			}
		}
		
		
		LayoutParamsProperties layout_props = component.getLayoutProps();
		
		for (int i = 0; i < layout_props.list_properties.size(); i++) {
			XmlSerializableProperty property = layout_props.list_properties.get(i);
			if (property.getValue() != null) {
				Log.v("ALE", "Attribute: " + property.toXmlAttribute() + "=" + property.getValue());
				serializer.attribute("", property.toXmlAttribute(), property.getValue());
			}
		}
		
	}

}
