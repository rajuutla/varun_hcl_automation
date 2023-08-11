package com.hcl.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.baseframework.BaseClass;

public class SignInPage extends BaseClass{

	WebDriver driver = null;
	
	public SignInPage(WebDriver driver) {
		// super(driver);							// Old Code
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(id="login2")
	WebElement signInLink;
	
	@FindBy(id="loginusername")
	WebElement signInUsername;
	
	@FindBy(id="loginpassword")
	WebElement signInPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement signInButton;
	
	@FindBy(id="logout2")
	WebElement LogoutLink;


	public void clickOnSignInLink() {
		clickOnElement(signInLink);
	}
	
	public void enterUsernamePassword(String username, String password) {
		clickOnElement(signInUsername);
		typeText(signInUsername,username);
		clickOnElement(signInPassword);
		typeText(signInPassword,password);
	}

	public void clickOnSignInButton() {
		clickOnElement(signInButton);
	}
	
	public void validateSignInSuccess() {
		System.out.println("Sign In Succesful");
		
	}
	
	public void clickOnLogoutLink(){
		System.out.println("Click on Logout link");
		clickOnElement(LogoutLink);
		System.out.println("Logout Succesful");
	}
}
