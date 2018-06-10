package com.vineet.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vineet.libs.ORMap;
import com.vineet.libs.PropertiesReader;

public class AddAddress {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		PropertiesReader envProp = new PropertiesReader("env.properties");
		ORMap objMap = new ORMap("ORMap.properties");
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium Vinod Sir\\Class_12-13 May\\downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);

		WebDriverWait wwait = new WebDriverWait(driver, 60);

		driver.get(envProp.getPropertyValue("BaseURL"));
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(objMap.getLocator("linkYourAC"));
		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

		driver.findElement(objMap.getLocator("SignIN")).click();
		
		driver.findElement(objMap.getLocator("emailId")).sendKeys("achiever.vineet@gmail.com");
		driver.findElement(objMap.getLocator("btnContinue")).click();
		driver.findElement(objMap.getLocator("password")).sendKeys("ChangeMe@2018");
		driver.findElement(objMap.getLocator("btnSubmit")).click();
		
		driver.findElement(By.xpath("//*[@id='nav-packard-glow-loc-icon']")).click();
		driver.findElement(By.xpath("//*[@id='GLUXManageAddressLink']/a")).click();
		driver.findElement(By.xpath("//*[@id='ya-myab-address-add-link']/div/div")).click();
		driver.findElement(By.xpath("//*[@id='address-ui-widgets-countryCode']/span/span")).click();
		
		WebElement ele = driver.findElement(By.className("a-native-dropdown"));
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText("Nepal");

		wwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressFullName")));
		wwait.until(ExpectedConditions.elementToBeClickable(By.id("address-ui-widgets-enterAddressFullName")));		
		
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("vineetgupta");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("89778787878");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("44613");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressLine1']")).sendKeys("Plot no-5");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressLine2']")).sendKeys("Thamel road");

		driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressCity']")).sendKeys("Kathmandu");

		driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion")).sendKeys("Kathmandu");

		// driver.findElement(By.xpath("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("040923887764");

		// driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressFormContainer']/span/span/input")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='address-ui-widget-content']/div/span/span/input")).click();

		// *[@id='address-ui-widgets-enterAddressCity']

	}
}
