package com.LibreTaximeter.libreTaximeter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class PairTabletScreen {
	AndroidDriver driver;

	@FindBy(id = CONSTANTS.BACK_BUTTON)
	private WebElement back_button;
	@FindBy(id = CONSTANTS.PAIR_TABLET_TITLE)
	static WebElement pair_tablet_title;
	@FindBy(id = CONSTANTS.AVAILABLE_DEVICES_TITLE)
	private WebElement available_devices_title;
	@FindBy(id = CONSTANTS.CONTINUE_WITHOUT_PAIRING)
	private WebElement continue_without_pairing;
	@FindBy(id = CONSTANTS.SUPPORT_NUMBER)
	private WebElement support_number;
	@FindBy(id = CONSTANTS.OK_BUTTON)
	private WebElement ok_button;
	
	
	

		
	public PairTabletScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	public void verifyBackButton() throws InterruptedException {
		this.back_button.click();
		Thread.sleep(2000);
	
}
	
	public void verifyPassengerModeElements() {
		Assert.assertTrue(this.back_button.isDisplayed());
		Assert.assertTrue(this.pair_tablet_title.isDisplayed());
		
	}
	
	public void verifyDriverModeElements() {
		Assert.assertTrue(this.back_button.isDisplayed());
		Assert.assertTrue(this.pair_tablet_title.isDisplayed());
		Assert.assertTrue(this.continue_without_pairing.isDisplayed());
		Assert.assertTrue(this.available_devices_title.isDisplayed());
		
	}
	
	public void continueWithoutPairing() throws InterruptedException {
		this.continue_without_pairing.click();
		Thread.sleep(2000);
	}
	
}


