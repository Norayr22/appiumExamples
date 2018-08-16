package com.LibreTaximeter.libreTaximeter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class EndTheDayPopUp {
	AndroidDriver driver;

	@FindBy(id = CONSTANTS.DAY_SUMMARY_TITLE)
    WebElement day_summary_title;
	@FindBy(id = CONSTANTS.CURRENT_DATE)
	private WebElement current_date;
	@FindBy(id = CONSTANTS.EARNINGS)
	private WebElement enearnings;
	@FindBy(id = CONSTANTS.DRIVEN_KMS)
	WebElement driven_kms;
	@FindBy(id = CONSTANTS.DRIVEN_HOURS)
	WebElement driven_hours;
	@FindBy(id = CONSTANTS.DRIVEN_MINUTES)
	WebElement driven_minutes;
	@FindBy(id = CONSTANTS.CANCEL_BUTTON)
	WebElement cancel_button;
	@FindBy(id = CONSTANTS.FINISH_DAY)
	WebElement finish_day;


	public EndTheDayPopUp(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void verifyElements() {
		Assert.assertTrue(this.day_summary_title.isDisplayed());
		Assert.assertTrue(this.current_date.isDisplayed());
		Assert.assertTrue(this.enearnings.isDisplayed());
		Assert.assertTrue(this.driven_kms.isDisplayed());
		Assert.assertTrue(this.driven_hours.isDisplayed());
		Assert.assertTrue(this.driven_minutes.isDisplayed());
		Assert.assertTrue(this.cancel_button.isDisplayed());
		Assert.assertTrue(this.finish_day.isDisplayed());
	}
	public void TapOnCancelButton() {
		this.cancel_button.click();
		Assert.assertTrue(CONSTANTS.DAY_SUMMARY_TITLE.isEmpty());
	}
	public void TapOnFinishDay() {
		this.finish_day.click();
	}
    public void checkDate() {
    	String timeStamp = new SimpleDateFormat("MMM dd, YYYY").format(Calendar.getInstance().getTime());
    	Assert.assertEquals(timeStamp, this.current_date.getText());
    }
}
