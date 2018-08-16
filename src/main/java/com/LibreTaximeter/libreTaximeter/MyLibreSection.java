package com.LibreTaximeter.libreTaximeter;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class MyLibreSection {
	AndroidDriver driver;

	@FindBy(xpath = CONSTANTS.CURRENT)
	WebElement current;;
	@FindBy(xpath = CONSTANTS.PREVIOUS)
	private WebElement previous;
	@FindBy(id = CONSTANTS.CLIENTS_NUMBER)
	private WebElement clients_number;
	@FindBy(id = CONSTANTS.DRIVER_RATING)
	WebElement driver_rating;
	@FindBy(id = CONSTANTS.KMS_DRIVEN)
	WebElement kms_drivern;
	@FindBy(id = CONSTANTS.HOURS_DRIVEN)
	WebElement hours_driven;
	@FindBy(id = CONSTANTS.MINUTES_DRIVEN)
	WebElement minutes_driven;
	@FindBy(id = CONSTANTS.TOTAL_EARNINGS)
	WebElement total_earnings;
	@FindBy(xpath = CONSTANTS.MESSAGES_AND_EVENTS)
	WebElement messages_and_ivents;;
	@FindBy(id = CONSTANTS.MESSAGE)
	List<WebElement> message;
		
	public MyLibreSection(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void verifyElements() {
	    Assert.assertTrue(current.isDisplayed());
	    Assert.assertTrue(previous.isDisplayed());
	    Assert.assertTrue(this.messages_and_ivents.isDisplayed());
	    Assert.assertTrue(this.driver_rating.isDisplayed());
	    Assert.assertTrue(this.clients_number.isDisplayed());
	    Assert.assertTrue(this.kms_drivern.isDisplayed());
	    Assert.assertTrue(this.hours_driven.isDisplayed());
	    Assert.assertTrue(this.total_earnings.isDisplayed());
	    Assert.assertTrue(this.minutes_driven.isDisplayed());
	}
	public void verifyDefaultScreen() {
		Assert.assertTrue(this.messages_and_ivents.isDisplayed());
		
	}
    
	public void arsen() {
		System.out.println(this.message.get(0).getAttribute("name"));
//		System.out.println(this.message.get(1).getAttribute("src"));
	}
}
