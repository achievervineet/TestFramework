package com.vineet.libs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	private Properties prop;
	
	public PropertiesReader(String filePath) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		
		fis.close();
	}
	
	public String getPropertyValue(String propName) {
		if(prop.containsKey(propName)) {
			return prop.getProperty(propName);
		}
		return null;		
	}
	
	public void setPropertyValue(String propName, String propValue, String filePath) throws IOException {
		prop.setProperty(propName, propValue);
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		prop.store(fos, "");
		fos.close();
	}
}