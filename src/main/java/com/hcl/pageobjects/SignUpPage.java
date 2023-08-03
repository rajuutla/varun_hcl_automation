package com.hcl.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.baseframework.BaseClass;

public class SignUpPage extends BaseClass{
	
	// Locators of the singup page - Username, passowrd, signuplink, singup, close, X etc.,
	// Actions of the singup page  
	  // - enterUsername, enterpssword, clickonsignup
	  // - singupMethod
	
	public SignUpPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="signin2")
	WebElement singUpLink;
	
	@FindBy(id="sign-username")
	WebElement signUpUserName;
	
	@FindBy(id="sign-password")
	WebElement singUpPassword;
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement singUpButton;
	
	
	public void clickOnSignUpLink() {
		clickOnElement(singUpLink);
	}
	
	public void signUp(String userEmail, String password) {
		
		typeText(signUpUserName, userEmail);
		typeText(singUpPassword, password);
		clickOnElement(singUpButton);
	}
	
	public boolean validateSingupSuccess() {
		
		String actualMessage = getAlertText();
		String expectedMessage = "Sign up successful.";
		
		return actualMessage.equals(expectedMessage)? true : false;
	}
	

}
