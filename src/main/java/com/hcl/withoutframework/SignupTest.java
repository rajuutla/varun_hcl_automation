package com.hcl.withoutframework;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcl.baseframework.DriverUtils;
import com.hcl.pageobjects.SignUpPage;

public class SignupTest {
	
	
	//1. Want the driver to be initialized as a common method
	
	WebDriver driver = null;
	SignUpPage signupPage = null;
	
	@BeforeMethod
	public void setup() {
		driver = DriverUtils.getDriver();
		signupPage = new SignUpPage(driver);
	}

	@Test (groups= {"smoke"})
	public void singUp() {
		
		// 1. Make the email random
		// 2. Do the validation with Login method with the same email used in singed up
		
		/*
		  	Given User is on the the home page
		  	   - Open the Chrome browser
		  	   - Open the application url 'https://www.demoblaze.com/index.html'
		  	   - Validate that i am on the home page
		   	When User clicks on Signup link
		   	   - Identifying the singup link object ( Locators - ID, NAME, LINK, XAPTH, CSS)
		   	<a class="nav-link" href="#" id="signin2" data-toggle="modal" data-target="#signInModal" style="display: block;">Sign up</a>
		   	   
		   	   //a[@id='signin2']
		   	    
		   	   - Perform the action ( click)
			And  User enters the new email and password on signup popup
			<input type="text" class="form-control" id="sign-username">
			And User clicks on Signup button on the signup popup
			Then validate that signup is successful
		 */
		
		signupPage.clickOnSignUpLink();
		signupPage.signUp("test1294@abc.com", "abcd123");
		boolean flag = signupPage.validateSignupSuccess();
		Assert.assertTrue(flag);
		
		
	/*	
		
		By singUpObj = By.id("signin2");
		WebElement signupEle = driver.findElement(singUpObj);
		signupEle.click();
		
		driver.findElement(By.id("sign-username")).sendKeys("test1294@abc.com");
		driver.findElement(By.id("sign-password")).sendKeys("abcd123");
		
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();
		
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();	
		String actualMessage = alert.getText();
		String expectedMessage = "Sign up successful.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
		System.out.println("Alert actual text = "+actualMessage);
		alert.accept();
	*/	

	}

}
