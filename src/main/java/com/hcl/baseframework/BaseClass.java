package com.hcl.baseframework;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	WebDriver driver = null;
	
	public BaseClass(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void typeText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void waitForAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertText() {
		waitForAlertPresence();
		Alert alert = driver.switchTo().alert();	
		String message = alert.getText();
		return message;
	}

}
