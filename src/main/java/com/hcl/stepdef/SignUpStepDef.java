package com.hcl.stepdef;

import org.testng.Assert;

import com.hcl.baseframework.DriverUtils;
import com.hcl.baseframework.Utilities;
import com.hcl.pageobjects.SignUpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDef {
	
	SignUpPage signup = null;
	
	@Given("User is on the the home page")
	public void Initialize_the_browser() {
		DriverUtils.getDriver();
	}
	
	@Given("Initialize the elements on the SignUp page")
	public void Initialize_the_elements_on_the_signup_page() {
		System.out.println("I am on the home page");
		signup = new SignUpPage(DriverUtils.driver);  // New Code
	}
	
	@When("User clicks on Signup link")
	public void user_clicks_on_signup_link() {
		signup.clickOnSignUpLink();
	}
	
	@When("User enters the new email and password on signup popup")
	public void user_enters_the_new_email_and_password_on_signup_popup() {
		int randomNumber = Utilities.randomNumberGenerator();
		//signup.signUp("username"+randomNumber+"@gmail.com", "abcd123");
		signup.signUp("username354@gmail.com", "abcd123");
	}
	
	@When("User clicks on Signup button on the signup popup")
	public void user_clicks_on_signup_button_on_the_signup_popup() {
		signup.clickOnSignUpButton();
	}
	
	@Then("validates that signup is successful")
	public void validates_that_signup_is_successful() {
		Assert.assertTrue(signup.validateSignupSuccess());
	}
	
	/*@AfterStep
	public void addScreenShot(Scenario sc) {
		final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screen, "image/png", sc.getName());
		
	}*/

}