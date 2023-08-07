package com.hcl.stepdef;

import org.openqa.selenium.WebDriver;

import com.hcl.baseframework.DriverUtils;
import com.hcl.pageobjects.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDef {

	WebDriver driver = null;
	SignInPage signIn = null;

	@Given ("User is on the the home page1")
	public void User_is_on_the_the_home_page() {
		driver = DriverUtils.getDriver();
		signIn = new SignInPage(driver);
 	}
	
	@When("User clicks on Signin link")
	public void user_clicks_on_signin_link() {
		signIn.clickOnSignInLink();
	}

	@When("User enters the email {string} and password {string} on signin popup")
	public void user_enters_the_email_and_password_on_signin_popup(String username, String password) {
		signIn.enterUsernamePassword(username, password);
	}

	@When("User clicks on Signin button on the signin popup")
	public void user_clicks_on_signin_button_on_the_signin_popup() {
		signIn.clickOnSignInButton();
		
	}

	@Then("validate that Signin is successful")
	public void validate_that_signin_is_successful() {
		signIn.validateSignInSuccess();
		
	}
}