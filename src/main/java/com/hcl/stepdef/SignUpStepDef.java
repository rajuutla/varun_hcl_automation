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
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
		DriverUtils.getDriver();
	}
	
	@Given("initialize the elements on the signup page")
	public void initialize_elements_singup_page() {
		System.out.println("I am on the home page");
		signup = new SignUpPage(DriverUtils.driver);
	}
	
	@When("User click on Signup link")
	public void user_click_on_signup_link() {
		signup.clickOnSignUpLink();
	}
	
	@When("User enter the new email and password on signup popup")
	public void user_enter_the_new_email_and_password_on_signup_popup() {
		int randomNumber = Utilities.randomNumberGenerator();
		//signup.signUp("username"+randomNumber+"@gmail.com", "abcd123");
		signup.signUp("username354@gmail.com", "abcd123");
	}
	
	@When("User click on Signup button on the signup popup")
	public void user_click_on_signup_button_on_the_signup_popup() {
		signup.clickOnSignUpButton();
	}
	
	@Then("validate that signup is successful")
	public void validate_that_signup_is_successful() {
		Assert.assertTrue(signup.validateSignupSuccess());
	}
	
	/*@AfterStep
	public void addScreenShot(Scenario sc) {
		final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screen, "image/png", sc.getName());
		
	}*/

}