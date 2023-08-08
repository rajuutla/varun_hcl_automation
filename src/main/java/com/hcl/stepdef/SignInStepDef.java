package com.hcl.stepdef;

import com.hcl.baseframework.DriverUtils;
import com.hcl.pageobjects.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDef {

	SignInPage signIn = null;
	
	  @Given("initialize the elements on the signin page") 
	  public void initialize_elements_signin_page() { 
		 //DriverUtils.getDriver(); 
		 signIn = new SignInPage(DriverUtils.driver); 
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
	
	@Given("Login into the application with username {string} and password {string}")
	public void login_into_app(String userName, String password) {
		signIn.clickOnSignInLink();
		signIn.enterUsernamePassword(userName, password);
		signIn.clickOnSignInButton();
		signIn.validateSignInSuccess();
	}
}