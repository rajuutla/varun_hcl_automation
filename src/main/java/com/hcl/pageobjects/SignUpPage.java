package com.hcl.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.baseframework.BaseClass;

public class SignUpPage extends BaseClass {

	// Locators of the singup page - Username, passowrd, signuplink, signup, close,
	// X etc.,
	// Actions of the signup page
	// - enterUsername, enterpssword, clickonsignup
	// - signupMethod

	Alert alert = null;

	public SignUpPage(WebDriver driver) {
		super(driver);
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

	public void signUp(String userEmail, String password) {

		clickOnElement(signUpUserName);
		typeText(signUpUserName, userEmail);
		clickOnElement(signUpPassword);
		typeText(signUpPassword, password);

	}

	public void clickOnSignUpButton() {
		clickOnElement(signUpButton);
	}

	public boolean validateSignupSuccess() {

		String actualMessage = verifyAlert("getText"); // getAlertText();
		String expectedMessage = "Sign up successful.";

		// return actualMessage.equals(expectedMessage)? true : false;
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Sign In Successful");
			verifyAlert("accept");
			return true;

		} else {
			System.out.println(verifyAlert("getText"));
			verifyAlert("accept");
			clickOnElement(closeButton);
			return false;
		}
	}

}