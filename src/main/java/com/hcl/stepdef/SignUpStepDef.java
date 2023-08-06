package com.hcl.stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDef {
	
	WebDriver driver = null;
	
	@Given("User is on the the home page")
	public void user_is_on_the_the_home_page() {
		System.out.println("I am on the home page");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("User click on Signup link")
	public void user_click_on_signup_link() {
		System.out.println("I clicked on the signup link");
		By singUpObj = By.id("signin2");
		WebElement signupEle = driver.findElement(singUpObj);
		signupEle.click();	}
	
	@When("User enter the new email and password on signup popup")
	public void user_enter_the_new_email_and_password_on_signup_popup() {
		driver.findElement(By.id("sign-username")).sendKeys("test1294@abc.com");
		driver.findElement(By.id("sign-password")).sendKeys("abcd123");
	}
	
	@When("User click on Signup button on the signup popup")
	public void user_click_on_signup_button_on_the_signup_popup() {
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();	}
	
	@Then("validate that signup is successful")
	public void validate_that_signup_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Signup successful");
	}
	
	@AfterStep
	public void addScreenShot(Scenario sc) {
		final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screen, "image/png", sc.getName());
		
	}

}
