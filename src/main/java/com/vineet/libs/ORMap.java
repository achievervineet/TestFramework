package com.vineet.libs;

import java.io.IOException;

import org.openqa.selenium.By;

public class ORMap {
	private PropertiesReader orProp;
	
	public ORMap(String OrPath) throws IOException {
		orProp = new PropertiesReader(OrPath);
	}
	
	public String[] getLocators(String objKey) {
		return orProp.getPropertyValue(objKey).split("::");
	}
	
	public By getLocator(String objKey) {
		String locType = orProp.getPropertyValue(objKey).split("::")[0];
		String locValue = orProp.getPropertyValue(objKey).split("::")[1];
				
		switch (locType.toUpperCase()) {
		case "ID":
			return By.id(locValue);
		case "XPATH":
			return By.xpath(locValue);
		case "NAME":
			return By.name(locValue);
		case "LINKTEXT":
		case "LINK":
			return By.linkText(locValue);
		case "CLASS":
		case "CLASSNAME":
			return By.className(locValue);
		case "CSS":
		case "CSSLOCATOR":
		case "CSSSELECTOR":
			return By.cssSelector(locValue);
		default:
			break;
		}
		return null;
	}
	
	
	
}
 