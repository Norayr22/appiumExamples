package com.LibreTaximeter.libreTaximeter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SuccessfulPairingTest {
	AndroidDriver driver1;
	AndroidDriver driver2;
	boolean isSuccess;
	boolean isSuccess1;
	
	

		
		@Test(priority = 1)
		public void verifyElementstest() throws InterruptedException, MalformedURLException {	
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "HJF0D0EN");
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.tenone.aa");
			capabilities.setCapability("appActivity", "com.tenone.activity.SplashActivity");
			driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WelcomeScreen welcome = new WelcomeScreen(driver1);
			welcome.verifyTapOnPassengerMode();
			PairTabletScreen pt = new PairTabletScreen(driver1);
			pt.verifyPassengerModeElements();
			isSuccess = true;
			driver1.closeApp();
			
		}


	@Test(priority = 1)
	public void driverModeElementsTest() throws InterruptedException, MalformedURLException {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "H1001713000910");
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.tenone.aa");
			capabilities.setCapability("appActivity", "com.tenone.activity.SplashActivity");
			driver2 = new AndroidDriver(new URL("http://127.0.0.1:8080/wd/hub"), capabilities);
			driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	
		WelcomeScreen welcome = new WelcomeScreen(driver2);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver2);
		pt.verifyDriverModeElements();
		isSuccess = true;
		driver2.closeApp();
		
	}

}
