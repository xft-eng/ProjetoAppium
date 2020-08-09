package br.xavier.compasso.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static  AndroidDriver<MobileElement> getDriver() {
		if (driver ==null) {
			creatDriver();
		}
		return driver;
	}

	
	private static void creatDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.fooddelivery_pro");
	    desiredCapabilities.setCapability("appActivity", "com.fooddelivery_pro.MainActivity");
	    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    
        try {
			driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public static void killdriver() {
		if( driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
