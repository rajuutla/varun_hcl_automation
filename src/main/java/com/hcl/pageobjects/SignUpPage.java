package com.hcl.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;

public class SignUpPage extends BaseClass {

	// Locators of the singup page - Username, passowrd, signuplink, signup, close,
	// X etc.,
	// Actions of the signup page
	// - enterUsername, enterpssword, clickonsignup
	// - signupMethod

	Alert alert = null;

	public SignUpPage() {
		//super(driver); 							// Old code
		PageFactory.initElements(DriverUtils.driver, this);
	}

	@FindBy(id = "signin2")
	WebElement signUpLink;

	@FindBy(id = "sign-username")
	WebElement signUpUserNameTextField;

	@FindBy(id = "sign-password")
	WebElement signUpPasswordTextField;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpButton;

	@FindBy(xpath = "//button[text()='Sign up']/preceding-sibling::button")
	WebElement closeButton;

	public void clickOnSignUpLink() {

		clickOnElement(signUpLink);
	}

	public void enterUsernamePasswordSignUp(String username, String password) {
		typeText(signUpUserNameTextField, username);
		typeText(signUpPasswordTextField, password);
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