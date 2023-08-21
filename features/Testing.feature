Feature: Add product(s) to cart feature
  User is able to add product to cart

  Background: 
    Given Initialize the elements on the PurchaseItems page
    And User has Login into the application with username "username354@gmail.com" and password "abcd123"

  @Run
Scenario Outline: Validate items in cart and Cart Value
    When User adds the following product "<productName>" and quantity "<productQty>" under category "<productType>" to cart
    And User navigates to cart
    Then validate that selected products are added to cart
    And User clears the cart
    And User clicks on Logout button

    Examples: 
      | productType 							| productName | productQty |
      | Laptops,Phones, Monitors  | Sony vaio i5: MacBook Pro,Samsung galaxy s6: Iphone 6 32gb, Apple monitor 24	|1:5,1:5,2  | 
 