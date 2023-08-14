package com.hcl.pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;

public class PurchaseItemsPage extends BaseClass{

	public static String productType ="";
	public String productTypeLinkName =" ";
	public PurchaseItemsPage() {
		// super(driver);								// Old Code
		PageFactory.initElements(DriverUtils.driver, this);
	}
	
	
	@FindBy(xpath="//*[contains(text(),'Phones')]")
	WebElement PhonesLink;
	
	@FindBy(xpath="//*[contains(text(),'Laptops')]")
	WebElement LaptopsLink;
	
	@FindBy(xpath="//*[contains(text(),'Monitors')]")
	WebElement MonitorsLink;
	
	@FindBy(xpath="")
	WebElement AppleMonitor24Link;
	
	/*@FindAll({
		@FindBy(xpath=("//h4[@class='card-title']")) 
		//@FindBy(xpath=("//h4[@class='card-title]"))
	})
	List<WebElement> productNamesLinks;	*/
	
	
	@FindBy(xpath=("//h4[@class='card-title']"))
	List<WebElement> productNamesLink;
	
	@FindBy(xpath=("//h4[@class='card-title']/a"))
	WebElement productNamesLink1;
	
	@FindBy(xpath="//*[contains(text(),'Add to cart')]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[contains(text(),'Cart')]")
	WebElement cartLink;
	
	@FindBy(xpath="//*[contains(text(),'Home')]")
	WebElement homeLink;
	
	@FindBy(xpath="")
	WebElement elemt;
	
	public void clickOnProductTypeLink(String productLink) {
		switch(productLink) {
		case "Phones": 
			scrollPage(PhonesLink);
			clickOnElement(PhonesLink);
			break;
		
		case "Laptops":
			scrollPage(LaptopsLink);
			clickOnElement(LaptopsLink);
			break;
			
		case "Monitors":
			scrollPage(MonitorsLink);
			clickOnElement(MonitorsLink);
			break;
		}
	}
	
	/*public void clickOnProductTypeLink(String productType) {
		//DriverUtils.driver.findElement(By.xpath("//*[contains(text(),'"+productLink+"')]"));
		//PurchaseItemsPage.productType=productType;
		//System.out.println("*** "+PhonesLink.findElement(By.partialLinkText(productType)));
		this.productType=productType;
		//System.out.println("Product Type: "+productType);
		switch(productType) {
		case "Phones": 
			scrollPage(PhonesLink);
			clickOnElement(PhonesLink);
			break;
		
		case "Laptops":
			scrollPage(LaptopsLink);
			clickOnElement(LaptopsLink);
			break;
			
		case "Monitors":
			scrollPage(MonitorsLink);
			clickOnElement(MonitorsLink);
			break;
		}
	}*/
	
	public void clickOnProductNameLink(String productName) {
		//System.out.println("Product name passed: "+productName);
		//DriverUtils.driver.findElement(By.xpath("//*[contains(text(),'Monitors')]"));
		//System.out.println("*** "+productNamesLink1);
		clickOnElement(DriverUtils.driver.findElement(By.partialLinkText(productName)));
		//waitForElementVisibility(productNamesLink.get(0).getText().equals(productName));
		//for(int i=0;i<productNamesLink.size();i++) {
		//	System.out.println("Print Product name: "+productNamesLink.get(i).getText());
		//}
	}
	
	public void addToCartButton(Integer addQty) {
		waitForElementVisibility(addToCartButton);
		for (int i = 0; i < addQty; i++) {
			clickOnElement(addToCartButton);
			handleAlert("getText");
			Assert.assertEquals(handleAlert("getText"), "Product added.");
			handleAlert("accept");
		}
	}
	
	public void clickOnCartLink() {
		clickOnElement(cartLink);
	}
	
	public void clickOnHomeLink() {
		clickOnElement(homeLink);
	}
}
