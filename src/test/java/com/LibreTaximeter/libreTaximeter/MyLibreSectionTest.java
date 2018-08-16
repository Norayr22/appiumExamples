package com.LibreTaximeter.libreTaximeter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class MyLibreSectionTest {
	AndroidDriver driver;
	boolean isSuccess;
	boolean isSuccess1;
	boolean isSuccess2;
	boolean isSuccess3;
	boolean isSuccess4;
	boolean isSuccess5;
	boolean isSuccess6;
	boolean isSuccess7;
	boolean isSuccess8;
	boolean isSuccess9;
	boolean isSuccess10;
	boolean isSuccess11;


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
	public void verifyElementsTest() throws InterruptedException{
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.verifysuccessfulLogin();
		MyLibreSection ml = new MyLibreSection(driver);
		ml.arsen();
		isSuccess = true;
		driver.closeApp();
		

	}
}