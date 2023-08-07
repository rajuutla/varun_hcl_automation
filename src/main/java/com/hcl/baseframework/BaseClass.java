package com.hcl.baseframework;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver = null;

	public BaseClass(WebDriver driver) {
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

	/*
	 * public String getAlertText() { waitForAlertPresence(); Alert alert =
	 * driver.switchTo().alert(); String message = alert.getText(); return message;
	 * }
	 * 
	 * public void alertAccept() { waitForAlertPresence(); Alert alert =
	 * driver.switchTo().alert(); alert.accept();
	 * 
	 * }
	 */

	public String verifyAlert(String alertType) {
		waitForAlertPresence();
		Alert alert = driver.switchTo().alert();
		if (alertType.equals("getText")) {
			String alertMessage = alert.getText();
			return alertMessage;
		} 
		
		else if (alertType.equals("dismiss")) {
			alert.dismiss();
			return "";
		} 
		
		else if (alertType.equals("accept")) {
			alert.accept();
			return "";
		}
		return "";
	}
	
	@SuppressWarnings("null")
	public void scrollPage(WebElement element) {
		JavascriptExecutor js = null;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void acceptAlert() {
		waitForAlertPresence();
		Alert alert = driver.switchTo().alert();	
		alert.accept();
	}

}
