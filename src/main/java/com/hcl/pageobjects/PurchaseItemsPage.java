package com.hcl.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.baseframework.BaseClass;

public class PurchaseItemsPage extends BaseClass{

	public PurchaseItemsPage(WebDriver driver) {
		// super(driver);								// Old Code
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Monitors')]")
	WebElement MonitorsLink;

	@FindBy(xpath="")
	WebElement AppleMonitor24Link;
	
	@FindBy(xpath="//*[contains(text(),'Add to cart')]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[contains(text(),'Cart')]")
	WebElement cartLink;
	
	@FindBy(xpath="")
	WebElement elemt;
	
	
}
