Feature: Add products to cart feature
  User is able to add multiple products to cart

  Scenario: Add products to cart
    Given User is on the the home page
    And Sign in is successful
    When User searches for a product "productName"
    And User adds multiple products "productQty" to cart
    And User navigates to cart
    Then validate that selected products are added to cart
    
   Examples: 
  	| productName | productQty  |
   	| Sony vaio i5 | 2 |
   	| MacBook Pro | 1 |
   	