package com.LibreTaximeter.libreTaximeter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import io.appium.java_client.android.AndroidDriver;

public class LoginScreen {
	AndroidDriver driver;

	@FindBy(id = CONSTANTS.LOGO)
	private WebElement logo;
	@FindBy(id = CONSTANTS.LIBRE_ID_FIELD)
	private WebElement libre_id_field;
	@FindBy(id = CONSTANTS.PASSWORD)
	private WebElement password;
	@FindBy(id = CONSTANTS.LOGIN_BUTTON)
	private WebElement login_button;
	@FindBy(id = CONSTANTS.FORGOT_PASSWORD)
	private WebElement forgot_password;
	@FindBy(id = CONSTANTS.PAIR_TABLET)
	private WebElement pair_tablet;
	@FindBy(xpath = CONSTANTS.EMPTY_FIELDS_ERROR)
	private WebElement empty_fields_error;
	@FindBy(xpath = CONSTANTS.EMPTY_USERBANE_ERROR)
	private WebElement empty_username_error;
	@FindBy(xpath = CONSTANTS.EMPTY_PASSWORD_ERROR)
	private WebElement empty_password_error;
	@FindBy(xpath = CONSTANTS.INVALID_CREDENTIALS_ERROR)
	private WebElement invalid_credentials_error;
	@FindBy(id = CONSTANTS.FORGOT_PASSWORD_TITLE)
	private WebElement forgot_password_title;

	

	

		
	public LoginScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
}
	public void elementsAreVisible() {
		Assert.assertTrue(this.logo.isDisplayed());
		Assert.assertTrue(this.libre_id_field.isDisplayed());
		Assert.assertTrue(this.password.isDisplayed());
		Assert.assertTrue(this.login_button.isDisplayed());
		Assert.assertTrue(this.forgot_password.isDisplayed());
		Assert.assertTrue(this.pair_tablet.isDisplayed());
	}
	
	public void verifyPasswordMasking() {
		this.password.click();
		this.password.sendKeys("llllll");
		Assert.assertNotEquals(this.password.getText(), "llllll");
		driver.hideKeyboard();
	}
	
	public void verifyEmptyFields() {
		this.login_button.click();
		Assert.assertTrue(this.empty_fields_error.isDisplayed());
	}
	
	public void verifyEmptyUsername() {
		this.password.click();
		this.password.sendKeys("llllll");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(this.empty_username_error.isDisplayed());
	}
	
	public void verifyEmptyPassword(){
		this.libre_id_field.click();
		this.libre_id_field.sendKeys("mvicente228");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(this.empty_password_error.isDisplayed());
	}
	
	public void loginWithInvalidUsername(){
		this.libre_id_field.click();
		this.libre_id_field.sendKeys("test");
		driver.hideKeyboard();
		this.password.click();
		this.password.sendKeys("llllll");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(this.invalid_credentials_error.isDisplayed());
	}
	
	public void loginWithInvalidPassword(){
		this.libre_id_field.click();
		this.libre_id_field.sendKeys("mvicente228");
		driver.hideKeyboard();
		this.password.click();
		this.password.sendKeys("222222");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(this.invalid_credentials_error.isDisplayed());
	}
	
	public void loginWithInvalidCredentials(){
		this.libre_id_field.click();
		this.libre_id_field.sendKeys("test");
		driver.hideKeyboard();
		this.password.click();
		this.password.sendKeys("222222");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(this.invalid_credentials_error.isDisplayed());
	}
	
	public void spacesAreIgnored() throws InterruptedException {
		this.libre_id_field.click();
		this.libre_id_field.sendKeys("m vi cen te 22 8");
		driver.hideKeyboard();
		this.password.click();
		this.password.sendKeys("pp pp p p");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(40000);
		Header header = new Header(driver);
		Assert.assertTrue(header.driver_name.isDisplayed());
		
	}
	public void verifysuccessfulLogin() throws InterruptedException {
		this.libre_id_field.click();
		this.libre_id_field.sendKeys("mvicente228");
		driver.hideKeyboard();
		this.password.click();
		this.password.sendKeys("llllll");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(40000);
		Header header = new Header(driver);
		Assert.assertTrue(header.driver_name.isDisplayed());
	}
	
	public void tapOnForgotPassword() {
		this.forgot_password.click();
		Assert.assertTrue(this.forgot_password_title.isDisplayed());
	}
	
	public void tapOnSettingsButton() {
		this.pair_tablet.click();
		Assert.assertTrue(PairTabletScreen.pair_tablet_title.isDisplayed());
	}
	
	public void verifyAutoLogin() throws InterruptedException {
		if(!driver.findElements(By.id(CONSTANTS.DRIVER_NAME)).isEmpty()) {
			driver.launchApp();
			Header header = new Header(driver);
			Assert.assertTrue(header.driver_name.isDisplayed());
			Thread.sleep(5000);
		}
		else {
		WelcomeScreen welcome = new WelcomeScreen(driver);
		welcome.verifyTapOnDriverMode();
		PairTabletScreen pt = new PairTabletScreen(driver);
		pt.continueWithoutPairing();
		this.libre_id_field.click();
		this.libre_id_field.clear();
		this.libre_id_field.sendKeys("mvicente228");
		driver.hideKeyboard();
		this.password.click();
		this.password.clear();
		this.password.sendKeys("pppppp");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(10000);
		Header header = new Header(driver);
		Assert.assertTrue(header.driver_name.isDisplayed());
		Thread.sleep(5000);
		driver.launchApp();
		Assert.assertTrue(header.driver_name.isDisplayed());
		Thread.sleep(5000);
		}
	}
	
}