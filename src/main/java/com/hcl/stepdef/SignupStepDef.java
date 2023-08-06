package com.hcl.stepdef;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hcl.baseframework.DriverUtils;
import com.hcl.pageobjects.SignUpPage;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepDef {
	
	WebDriver driver = null;
	SignUpPage signup = null;
	
	@Given("User is on the the home page")
	public void user_is_on_the_the_home_page() {
		System.out.println("I am on the home page");
		driver = DriverUtils.getDriver();
		signup = new SignUpPage(driver);
	}
	
	@When("User click on Signup link")
	public void user_click_on_signup_link() {
		signup.clickOnSignUpLink();
	}
	
	@When("User enter the new email and password on signup popup")
	public void user_enter_the_new_email_and_password_on_signup_popup() {
		signup.signUp("test1294@abc.com", "abcd123");
	}
	
	@When("User click on Signup button on the signup popup")
	public void user_click_on_signup_button_on_the_signup_popup() {
		signup.clickOnSignUpButton();
	}
	
	@Then("validate that signup is successful")
	public void validate_that_signup_is_successful() {
		System.out.println("Signup successful");
		signup.validateSignupSuccess();
	}
	
	@AfterStep
	public void addScreenShot(Scenario sc) {
		final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screen, "image/png", sc.getName());
		
	}

}