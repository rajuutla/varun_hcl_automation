package com.hcl.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.hcl.baseframework.BaseClass;

public class SignUpPage extends BaseClass {

	// Locators of the singup page - Username, passowrd, signuplink, signup, close,
	// X etc.,
	// Actions of the signup page
	// - enterUsername, enterpssword, clickonsignup
	// - signupMethod

	Alert alert = null;

	public SignUpPage(WebDriver driver) {
		//super(driver); 							// Old code
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "signin2")
	WebElement signUpLink;

	@FindBy(id = "sign-username")
	WebElement signUpUserName;

	@FindBy(id = "sign-password")
	WebElement signUpPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpButton;

	@FindBy(xpath = "//button[text()='Sign up']/preceding-sibling::button")
	WebElement closeButton;
	
	public void clickOnSignUpLink() {
		
		clickOnElement(signUpLink);
	
	}

	public void signUp(String username, String password) {
	
		clickOnElement(signUpUserName);
		typeText(signUpUserName, username);
		clickOnElement(signUpPassword);
		typeText(signUpPassword, password);

	}

	public void clickOnSignUpButton() {
		clickOnElement(signUpButton);
	}

	public void validateSignupSuccess() {

		// return actualMessage.equals(expectedMessage)? true : false;
		Assert.assertTrue((handleAlert("getText").equals("Sign up successful.")));
		handleAlert("accept");
	}
	
	public void validateSignupFail() {
		//System.out.println(handleAlert("getText"));
		Assert.assertTrue((handleAlert("getText").equals("This user already exist.")));
		handleAlert("accept");
		clickOnElement(closeButton);
	}

}