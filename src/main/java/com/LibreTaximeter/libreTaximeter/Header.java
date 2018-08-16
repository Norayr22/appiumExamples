package com.LibreTaximeter.libreTaximeter;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Header {
	AndroidDriver driver;

	@FindBy(id = CONSTANTS.DRIVER_NAME)
	public WebElement driver_name;
	@FindBy(id = CONSTANTS.AVATAR)
	private WebElement avatar;
	@FindBy(id = CONSTANTS.END_DAY)
	private WebElement end_day;
	@FindBy(id = CONSTANTS.EMERGENCY)
	WebElement emergency;
	@FindBy(id = CONSTANTS.LIBRE_BALANCE)
	WebElement libre_balance;
	

		
	public Header(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void verifyElements() {
		 Assert.assertTrue(this.driver_name.isDisplayed());
		 Assert.assertTrue(this.avatar.isDisplayed());
		 Assert.assertTrue(this.end_day.isDisplayed());
		 Assert.assertTrue(this.emergency.isDisplayed());
		 Assert.assertTrue(this.libre_balance.isDisplayed());
	}
    public void tapOnEndTheDay() {
    	this.end_day.click();
    	EndTheDayPopUp end  = new EndTheDayPopUp(driver);
        Assert.assertTrue(end.day_summary_title.isDisplayed());
    }
	
}
