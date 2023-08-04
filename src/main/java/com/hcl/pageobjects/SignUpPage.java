package com.hcl.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.baseframework.BaseClass;

public class SignUpPage extends BaseClass{
	
	// Locators of the singup page - Username, passowrd, signuplink, signup, close, X etc.,
	// Actions of the signup page  
	  // - enterUsername, enterpssword, clickonsignup
	  // - signupMethod
	
	public SignUpPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="signin2")
	WebElement signUpLink;
	
	@FindBy(id="sign-username")
	WebElement signUpUserName;
	
	@FindBy(id="sign-password")
	WebElement signUpPassword;
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signUpButton;
	
	
	public void clickOnSignUpLink() {
		clickOnElement(signUpLink);
		System.out.println("Varun");
	}
	
	public void signUp(String userEmail, String password) {
		
		typeText(signUpUserName, userEmail);
		typeText(signUpPassword, password);
		clickOnElement(signUpButton);
	}
	
	public boolean validateSignupSuccess() {
		
		String actualMessage = getAlertText();
		String expectedMessage = "Sign up successful.";
		
		return actualMessage.equals(expectedMessage)? true : false;
	}
	

}
