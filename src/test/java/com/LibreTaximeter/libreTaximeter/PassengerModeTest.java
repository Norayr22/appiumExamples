package com.LibreTaximeter.libreTaximeter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class PassengerModeTest {
	AndroidDriver driver;
	boolean isSuccess;
	boolean isSuccess1;
	
	
	@BeforeSuite()
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "H1001713000910");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "5.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.tenone.aa");
		capabilities.setCapability("appActivity", "com.tenone.activity.SplashActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4492/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
	
	@Test(priority = 1)
	public void verifyElementstest() throws InterruptedException {	
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnPassengerMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.verifyPassengerModeElements();
		isSuccess = true;
		driver.closeApp();
		
	}
	
	@Test(priority = 2)
	public void verifyBackButtonTest() throws InterruptedException {
		driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnPassengerMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.verifyBackButton();
		isSuccess1 = true;
		driver.closeApp();
		
	}
	

}