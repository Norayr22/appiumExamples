package com.LibreTaximeter.libreTaximeter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordScreen {
	AndroidDriver driver;

	@FindBy(id = CONSTANTS.FORGOT_TITLE)
	private WebElement forgot_title;
	@FindBy(id = CONSTANTS.SUPPORT_NUMBER)
	private WebElement support_number;
	@FindBy(id = CONSTANTS.OK_BUTTON)
	private WebElement ok_button;
	
	
	

		
	public ForgotPasswordScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void verifyUiElements() {
		Assert.assertTrue(this.forgot_title.isDisplayed());
		Assert.assertTrue(this.support_number.isDisplayed());
		Assert.assertTrue(this.ok_button.isDisplayed());
	}
	
	public void verifySupportNumber() {
		Assert.assertEquals(this.support_number.getText(), "+55 292 4928 21");

	}
	
	public void verifyOkButton() {
		this.ok_button.click();
		Assert.assertTrue(driver.findElements(By.id(CONSTANTS.FORGOT_TITLE)).isEmpty());
		
	}
}

