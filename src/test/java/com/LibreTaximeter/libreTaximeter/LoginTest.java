package com.LibreTaximeter.libreTaximeter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
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
	public void verifyElementsTest() throws InterruptedException {
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.elementsAreVisible();
		isSuccess = true;
		driver.closeApp();
	}
	
	@Test(priority = 2)
	public void passwordMaskingTest() throws InterruptedException {
		driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.verifyPasswordMasking();
		isSuccess1 = true;
		driver.closeApp();
	}
	
    @Test(priority = 3)
	public void emptyFieldsTest() throws InterruptedException {
    	driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.verifyEmptyFields();
		isSuccess2 = true;
		driver.closeApp();
    }
    
    @Test(priority = 4)
	public void emptyUsernameTest() throws InterruptedException {
    	driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.verifyEmptyUsername();
		isSuccess3 = true;
		driver.closeApp();
    }
    
    @Test(priority = 5)
	public void emptyPasswordTest() throws InterruptedException {
    	driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.verifyEmptyPassword();
		isSuccess4 = true;
		driver.closeApp();
    }
    
    @Test(priority = 6)
	public void loginWithInvalidUsernameTest() throws InterruptedException {
    	driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.loginWithInvalidUsername();
		isSuccess5 = true;
		driver.closeApp();
    }
    
    @Test(priority = 7)
	public void loginWithInvalidPasswordTest() throws InterruptedException {
    	driver.launchApp();
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		LoginScreen login = new LoginScreen(driver);
		login.loginWithInvalidPassword();
		isSuccess6 = true;
		driver.closeApp();
    }
    
    @Test(priority = 8)
   	public void loginWithInvalidCredentialsTest() throws InterruptedException {
       	driver.launchApp();
   		WelcomeScreen welcome = new WelcomeScreen(driver);
   		welcome.verifyTapOnDriverMode();
   		PairTabletScreen pt = new PairTabletScreen(driver);
   		pt.continueWithoutPairing();
   		LoginScreen login = new LoginScreen(driver);
   		login.loginWithInvalidCredentials();
   		isSuccess7 = true;
   		driver.closeApp();
       }
    
    @Test(priority = 9)
   	public void spacesAreIgnoredTest() throws InterruptedException {
       	driver.launchApp();
   		WelcomeScreen welcome = new WelcomeScreen(driver);
   		welcome.verifyTapOnDriverMode();
   		PairTabletScreen pt = new PairTabletScreen(driver);
   		pt.continueWithoutPairing();
   		LoginScreen login = new LoginScreen(driver);
   		login.spacesAreIgnored();
   		isSuccess8 = true;
   		driver.closeApp();
       }
    
    @Test(priority = 10)
   	public void successfulLoginTest() throws InterruptedException {
       	driver.launchApp();
   		WelcomeScreen welcome = new WelcomeScreen(driver);
   		welcome.verifyTapOnDriverMode();
   		PairTabletScreen pt = new PairTabletScreen(driver);
   		pt.continueWithoutPairing();
   		LoginScreen login = new LoginScreen(driver);
   		login.verifysuccessfulLogin();
   		isSuccess9 = true;
   		driver.closeApp();
       }
    
    @Test(priority = 11)
   	public void ForgotPasswrodButtonTest() throws InterruptedException {
       	driver.launchApp();
   		WelcomeScreen welcome = new WelcomeScreen(driver);
   		welcome.verifyTapOnDriverMode();
   		PairTabletScreen pt = new PairTabletScreen(driver);
   		pt.continueWithoutPairing();
   		LoginScreen login = new LoginScreen(driver);
   		login.tapOnForgotPassword();
   		isSuccess10 = true;
   		driver.closeApp();
       }
    
    @Test(priority = 12)
   	public void SettingsButtonTest() throws InterruptedException {
       	driver.launchApp();
   		WelcomeScreen welcome = new WelcomeScreen(driver);
   		welcome.verifyTapOnDriverMode();
   		PairTabletScreen pt = new PairTabletScreen(driver);
   		pt.continueWithoutPairing();
   		LoginScreen login = new LoginScreen(driver);
   		login.tapOnSettingsButton();
   		isSuccess11 = true;
   		driver.closeApp();
       }
    
}
