package com.chawran.core.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@SuppressWarnings("all")
public class XMLUtil {

	private static XStream xStream = new XStream(new DomDriver("UTF-8"));

	// XML转Java对象
	public static Object xml2Java(String xml) {
		return xStream.fromXML(xml);
	}

	// Java对象转XML
	public static String java2Xml(Object obj, String alias) {
		xStream.alias(alias, obj.getClass());
		return xStream.toXML(obj);
	}

}
