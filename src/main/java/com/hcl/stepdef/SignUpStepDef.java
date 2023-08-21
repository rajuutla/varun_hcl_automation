package com.hcl.stepdef;

import java.io.IOException;

import com.hcl.baseframework.Utilities;
import com.hcl.pageobjects.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDef {

	SignUpPage signUp = null;

	@Given("Initialize the elements on the SignUp page")
	public void initialize_the_elements_on_the_signup_page() {
		signUp = new SignUpPage(); // New Code
	}

	@When("User clicks on Signup link")
	public void user_clicks_on_signup_link() {
		signUp.clickOnSignUpLink();
	}

	@When("User enters the new email and password on signup popup")
	public void user_enters_the_new_email_and_password_on_signup_popup() {
		int randomNumber = Utilities.randomNumberGenerator();
		signUp.enterUsernamePasswordSignUp("username" + randomNumber + "@gmail.com", "abcd123");
	}

	@When("User clicks on Signup button on the signup popup")
	public void user_clicks_on_signup_button_on_the_signup_popup() {
		signUp.clickOnSignUpButton();
	}

	@Then("validate that signup is successful")
	public void validate_that_signup_is_successful() throws IOException {
		signUp.validateSignupSuccess();
	}

	@When("User enters the existing email {string} and existing password {string} on signup popup")
	public void user_enters_the_existing_email_and_existing_password_on_signup_popup(String username, String password) {
		signUp.enterUsernamePasswordSignUp(username, password);
	}

	@Then("validate that signup is unsuccessful")
	public void validate_that_signup_is_unsuccessful() throws IOException {
		signUp.validateSignupFail();
	}

}