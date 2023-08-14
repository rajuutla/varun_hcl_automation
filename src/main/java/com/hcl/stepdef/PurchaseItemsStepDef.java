package com.hcl.stepdef;

import com.hcl.pageobjects.PurchaseItemsPage;
import com.hcl.pageobjects.SignInPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseItemsStepDef {

	PurchaseItemsPage purchaseItems = null;
	
	@Given("Initialize the elements on the PurchaseItems page")
	public void initialize_the_elements_on_the_PurchaseItems_page() {
		purchaseItems = new PurchaseItemsPage();			
	}
	
	@When ("User clicks on product type link {string}") 
	public void user_clicks_on_product_type_link(String productType) {
		purchaseItems.clickOnProductTypeLink(productType);
	}
	
	@When("User searches for a product {string}")
	public void user_searches_for_a_product(String productName) {
		purchaseItems.clickOnProductNameLink(productName);
	}

	@When("User adds multiple quantities {int} of above product to cart")
	public void user_adds_multiple_quantities_of_above_product_to_cart(Integer Qty) {
		purchaseItems.addToCartButton(Qty);
	}

	@When("User navigates to cart")
	public void user_navigates_to_cart() {
		purchaseItems.clickOnCartLink();
	}
	
	@Then("validate that selected product is added to cart")
	public void validate_that_selected_product_is_added_to_cart() {
		
	}
	
	@Then("validate that selected products are added to cart")
	public void validate_that_selected_products_are_added_to_cart() {
	   
	}

	@When("User navigates to Home page")
	public void user_navigates_to_home_page() {
		purchaseItems.clickOnHomeLink();	
	}
}
