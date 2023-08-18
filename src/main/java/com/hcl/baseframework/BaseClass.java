package com.hcl.baseframework;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	JavascriptExecutor js = (JavascriptExecutor) DriverUtils.driver;

	//WebDriver driver = null;   						// Old Code

	/*public BaseClass(WebDriver driver) {
		this.driver = driver;
	}*/ 												// Old Code

	public void clickOnElement(WebElement element) {
		waitForElementToBeVisible(element);
		element.click();
	}

	public void typeText(WebElement element, String value) {
		waitForElementToBeClickable(element);
		element.sendKeys(value);
	}

	public void waitForAlertPresence() {
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public String handleAlert(String alertType) {
		waitForAlertPresence();
		Alert alert = DriverUtils.driver.switchTo().alert();  // New Code
		switch(alertType) {
		case "getText":
			return alert.getText();
		}

		if (alertType.equals("getText")) {
			return alert.getText();
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

	public void scrollPage(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void jsClickElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement getDriverElement(String locator1, String locator2) {
		return DriverUtils.driver.findElement(By.xpath(locator1+locator2));
	}
	
}
