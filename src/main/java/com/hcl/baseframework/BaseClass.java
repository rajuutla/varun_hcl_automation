package com.hcl.baseframework;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	//WebDriver driver = null;   						// Old Code

	/*public BaseClass(WebDriver driver) {
		this.driver = driver;
	}*/ 												// Old Code

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void typeText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void waitForAlertPresence() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Old Code
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(10));  // New Code
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String handleAlert(String alertType) {
		waitForAlertPresence();
		// Alert alert = driver.switchTo().alert();  // old Code
		Alert alert = DriverUtils.driver.switchTo().alert();  // New Code
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

}
