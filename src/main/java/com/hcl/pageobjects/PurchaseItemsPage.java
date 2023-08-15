package com.hcl.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;
import com.hcl.baseframework.Utilities;

public class PurchaseItemsPage extends BaseClass{

	HashMap<String, Integer> productsInCart = new HashMap<String, Integer>();
	public static String productType ="";
	public String productTypeLinkName =" ";
	WebDriver driver = DriverUtils.driver;

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

	@FindBy(xpath=("//h4[@class='card-title']/a"))
	WebElement productNamesLink;

	@FindBy(xpath="//*[contains(text(),'Add to cart')]")
	WebElement addToCartButton;

	@FindBy(xpath=("//tr[@class='success']"))
	List<WebElement> itemsInCart;
	
	@FindBy(linkText="Delete")
	List<WebElement> deleteCartItemCount;
	
	@FindBy(linkText="Delete")
	WebElement deleteCartItemLink;
	
	@FindBy(id="totalp")
	WebElement totalCartValue;
	
	@FindBy(xpath="//*[contains(text(),'Cart')]")
	WebElement cartLink;

	@FindBy(partialLinkText="Home")
	WebElement homeLink;

	@FindBy(xpath="//button[(text()='Place Order')]")
	WebElement placeOrderButton;

	@FindBy(id="name")
	WebElement placeOrderNameTextField;

	@FindBy(id="country")
	WebElement placeOrderCountryTextField;

	@FindBy(id="city")
	WebElement placeOrderCityTextField;

	@FindBy(id="card")
	WebElement placeOrderCreditCardTextField;

	@FindBy(id="month")
	WebElement placeOrderMonthTextField;

	@FindBy(id="year")
	WebElement placeOrderYearTextField;

	@FindBy(xpath="//*[contains(text(),'Purchase')]/preceding-sibling::button")
	WebElement placeOrderCloseButton;
	
	@FindBy(xpath="//button[(text()='Purchase')]")
	WebElement placeOrderPurchaseButton;

	@FindBy(xpath="//*[contains(text(),'Thank you for your purchase!')]")
	WebElement thankYouPurchaseText;

	@FindBy(xpath="//p[@class = 'lead text-muted ']")
	WebElement orderIDText;

	@FindBy(xpath="//button[(text()='OK')]")
	WebElement purchaseOrderOKButton;
	
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

	public void clickOnPlaceOrderButton() {
		clickOnElement(placeOrderButton);
	}

	public void enterPlaceOrderNameTextField(String name) {
		clickOnElement(placeOrderNameTextField);
		typeText(placeOrderNameTextField,name);
	}

	public void enterPlaceOrderCountryTextField(String country) {
		clickOnElement(placeOrderCountryTextField);
		typeText(placeOrderCountryTextField,country);
	}

	public void enterPlaceOrderCityTextField(String city) {
		clickOnElement(placeOrderCityTextField);
		typeText(placeOrderCityTextField,city);
	}

	public void enterPlaceOrderCreditCardTextField(String card) {
		clickOnElement(placeOrderCreditCardTextField);
		typeText(placeOrderCreditCardTextField,card);
	}

	public void enterPlaceOrderMonthTextField(String month) {
		clickOnElement(placeOrderMonthTextField);
		typeText(placeOrderMonthTextField,month);
	}

	public void enterPlaceOrderYearTextField(String year) {
		clickOnElement(placeOrderYearTextField);
		typeText(placeOrderYearTextField,year);
	}

	public void clickOnPlaceOrderPurchaseButton() {
		clickOnElement(placeOrderPurchaseButton);
	}

	public void validateOrderIDSuccess() {
		waitForElementVisibility(thankYouPurchaseText);
		String orderId = orderIDText.getText();
		orderId = Utilities.splitStringExtractText(orderId,"\n");
		System.out.println("** Order "+orderId+" **");
	}

	public void clickOnPurchaseOrderOKButton() {
		clickOnElement(purchaseOrderOKButton);
		clickOnHomeLink();
	}

	public void clickOnPlaceOrderCloseButton() {
		//clickOnElement(placeOrderCloseButton);
	}
	
	public void addItemsToCart(String productType, String productName, Integer Qty) {
		clickOnProductTypeLink(productType);
		clickOnProductNameLink(productName);
		addToCartButton(Qty);
		productsInCart.put(productName, Qty);
		clickOnHomeLink();
	}
	
	public void validateTotalCartValue() {
		waitForElementVisibility(totalCartValue);
		Assert.assertFalse(totalCartValue.getText().isBlank());
	}
	
	public void validateAddedProductsInCart() {
		int itemCount=0;
		int cartValue=0;
		//int itemsInCart = driver.findElements(By.xpath("//tr[@class='success']")).size();
		for(Map.Entry map : productsInCart.entrySet()){
			for(int i=0;i<(int)map.getValue();i++) {
				String productName = "//td[contains(text(),'"+map.getKey()+"')]";
				
				//System.out.println("productNameLocator: "+productName);
				//productName = itemsInCart.toString().concat(productName);
				//System.out.println("productNameLocatorConcatenate: "+productName);
				
				String productCost = productName+"/following-sibling::td";
				productName = driver.findElement(By.xpath(productName)).getText();
				productCost = driver.findElement(By.xpath(productCost)).getText();
				
				//System.out.println("Product Name: "+productName);
				//System.out.println("Product Cost: "+productCost);
				
				cartValue=cartValue+Integer.parseInt(productCost);
				itemCount=itemCount+1;
			}    
		}
		Assert.assertEquals(Integer.parseInt(totalCartValue.getText()), cartValue);
	}
	
	public void flushCartItems() throws InterruptedException {
		if(!totalCartValue.getText().isBlank()) {
			int itemCount = deleteCartItemCount.size();
			for(int i=itemCount;i>0;i--) {
				Thread.sleep(1000);
				clickOnElement(deleteCartItemLink);
			}
		}
		clickOnHomeLink();
	}
}
