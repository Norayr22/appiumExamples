package com.LibreTaximeter.libreTaximeter;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class NavigationBar {

	AndroidDriver driver;

	@FindBy(id = CONSTANTS.MY_LIBRE)
    WebElement my_libre;
	@FindBy(id = CONSTANTS.SUMMARIES)
	private WebElement summaries;
	@FindBy(id = CONSTANTS.CONTACTS)
	private WebElement contacts;
	@FindBy(id = CONSTANTS.START_DAY)
	WebElement start_day;
	@FindBy(id = CONSTANTS.BACK_TO_MAP)
	WebElement back_to_map;
	

		
	public NavigationBar(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void verifyElements() {
	    Assert.assertTrue(this.my_libre.isDisplayed());
	    Assert.assertTrue(this.summaries.isDisplayed());
	    Assert.assertTrue(this.contacts.isDisplayed());
	    Assert.assertTrue(this.start_day.isDisplayed());
	}
    public void TapOnMyLibreSection() {
    	this.my_libre.click();
    	
    }
	
    public void TapOnSummariesSection() {
    	this.summaries.click();
    }
    public void TapOnContactsSection() {
    	this.contacts.click();
    }
    public void TapOnStartDay() {
    	this.start_day.click();
    }
    public void TapOnBackToMap() {
    	this.back_to_map.click();
    }
 
}


