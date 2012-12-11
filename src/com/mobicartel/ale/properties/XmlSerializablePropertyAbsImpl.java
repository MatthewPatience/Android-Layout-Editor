package com.mobicartel.ale.properties;




public abstract class XmlSerializablePropertyAbsImpl implements XmlSerializableProperty {

	public String toXmlAttribute() {
		
		return "android:" + getName();
	}
	
}
