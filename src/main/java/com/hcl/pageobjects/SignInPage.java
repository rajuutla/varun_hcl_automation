package com.hcl.pageobjects;

import java.time.Duration;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;

public class SignInPage extends BaseClass{

	WebDriver driver = null;
	
	public SignInPage() {
		// super(driver);			// Old Code
		PageFactory.initElements(DriverUtils.driver, this);	
	}
	
	@FindBy(id="login2")
	WebElement signInLink;
	
	@FindBy(id="loginusername")
	WebElement signInUsername;
	
	@FindBy(id="loginpassword")
	WebElement signInPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement signInButton;
	
	@FindBy(id="nameofuser")
	WebElement welcomeUserText;
	
	@FindBy(id="logout2")
	WebElement LogoutLink;
	
	@FindBy(xpath = "//button[text()='Log in']/preceding-sibling::button")
	WebElement closeButton;


	public void clickOnSignInLink() {
		clickOnElement(signInLink);
	}
	
	public void enterUsernamePasswordSignIn(String username, String password) {
		clickOnElement(signInUsername);
		typeText(signInUsername,username);
		clickOnElement(signInPassword);
		typeText(signInPassword,password);
	}

	public void clickOnSignInButton() throws InterruptedException {
		clickOnElement(signInButton);
		Thread.sleep(1000);
	}
	
	public void validateSignInSuccess() {
		waitForElementVisibility(welcomeUserText);
		Assert.assertTrue(welcomeUserText.getText().startsWith("Welcome"));
	}
	
	public void validateSignInFailInvalidPassword() throws InterruptedException {
		Thread.sleep(1000);
		//System.out.println(handleAlert("getText"));
		Assert.assertTrue(handleAlert("getText").equals("Wrong password."));
		handleAlert("accept");
		clickOnElement(closeButton);
	}
	
	public void validateSignInFailUnregisteredUser() throws InterruptedException {
		Thread.sleep(1000);
		//System.out.println(handleAlert("getText"));
		Assert.assertTrue(handleAlert("getText").equals("User does not exist."));
		handleAlert("accept");
		clickOnElement(closeButton);
	}
	
	public void clickOnLogoutLink() {
		clickOnElement(LogoutLink);
	}
	
	public void validateMissingUsernamePassword() {
		Assert.assertTrue(handleAlert("getText").equals("Please fill out Username and Password."));
		handleAlert("accept");
		clickOnElement(closeButton);
	}
}
