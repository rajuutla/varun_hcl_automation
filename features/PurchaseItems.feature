Feature: Add product(s) to cart feature
  User is able to add product to cart

  Background: 
    Given Initialize the elements on the PurchaseItems page
    And User has Login into the application with username "username354@gmail.com" and password "abcd123"
  
  @Smoke
  Scenario Outline: Add multiple quantities of a product to cart
    When User clicks on product type link "Laptops"
    And User searches for a product "<productName>"
    And User adds multiple quantities <productQty> of above product to cart
    And User navigates to cart
    Then validate that selected products are added to cart

    Examples: 
      | productName  | productQty |
      | Sony vaio i5 |          2 |

  @Smoke
  Scenario Outline: Add multiple products to cart
    When User clicks on product type link "Laptops"
    And User searches for a product "Sony vaio i5"
    And User adds multiple quantities 2 of above product to cart
    And User navigates to Home page
    And User clicks on product type link "Laptops"
    And User searches for a product "MacBook Pro"
    And User adds multiple quantities 2 of above product to cart
    And User navigates to cart
    Then validate that selected products are added to cart
