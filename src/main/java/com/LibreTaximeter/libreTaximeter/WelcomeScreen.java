package com.LibreTaximeter.libreTaximeter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class WelcomeScreen {

	AndroidDriver driver;

	@FindBy(id = CONSTANTS.DRIVER_MODE) 
	public static WebElement driver_mode;
	@FindBy(id = CONSTANTS.PASSENGER_MODE)
	private WebElement passenger_mode;
	@FindBy(id = CONSTANTS.LIBRE_LOGO)
	private WebElement libre_logo;
	@FindBy(id = CONSTANTS.TO_GET_STARTED)
	private WebElement to_get_started;
	@FindBy(xpath = CONSTANTS.TABLET_MODE)
	private WebElement tablet_mode;
	

		
	public WelcomeScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
    public void verifyElements(){
		Assert.assertTrue(this.libre_logo.isDisplayed());
		Assert.assertTrue(this.driver_mode.isDisplayed());
		Assert.assertTrue(this.passenger_mode.isDisplayed());
		Assert.assertTrue(this.tablet_mode.isDisplayed());
		Assert.assertTrue(this.to_get_started.isDisplayed());
	}
   
    public void verifyTapOnPassengerMode() throws InterruptedException {
    	this.passenger_mode.click();
    	Thread.sleep(2000);
    	
    }
    
    public void verifyTapOnDriverMode() throws InterruptedException {
    	this.driver_mode.click();
    	Thread.sleep(2000);
    }
	}

	

   
