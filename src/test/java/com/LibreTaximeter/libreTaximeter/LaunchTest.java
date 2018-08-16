package com.LibreTaximeter.libreTaximeter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LaunchTest{
	AndroidDriver driver;
	boolean isSuccess;
	boolean isSuccess1;
	boolean isSuccess2;
	boolean isSuccess3;
	boolean isSuccess4;
	boolean isSuccess5;
	
	@BeforeSuite()
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "HJF0D0EN");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.tenone.aa");
		capabilities.setCapability("appActivity", "com.tenone.activity.SplashActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


}
	@Test(priority = 1)
	public void verifyElementsTest(){
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyElements();
		isSuccess = true;
		driver.closeApp();
	}
	
	@Test(priority = 2)
	public void passengerModeTest() throws InterruptedException {
		driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnPassengerMode();
		isSuccess1 = true;
		driver.closeApp();
	}
	
	@Test(priority = 3)
	public void driverModeTest() throws InterruptedException {
		driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		isSuccess2 = true;
		driver.closeApp();
	}
	
}