package com.LibreTaximeter.libreTaximeter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AutoLoginTest {
	AndroidDriver driver;
	boolean isSuccess;
	


	@BeforeSuite()
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "HJF0D0EN");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability("appPackage", "com.tenone.aa");
		capabilities.setCapability("appActivity", "com.tenone.activity.SplashActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		


}
	@Test()
	public void autoLoginTest() throws InterruptedException {
		LoginScreen login = new LoginScreen(driver);
		login.verifyAutoLogin();
		isSuccess = true;
		driver.closeApp();

	}
	
	}