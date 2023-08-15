Feature: Add product(s) to cart feature

  Background: 
    Given Initialize the elements on the PurchaseItems page
    And User has Login into the application with username "username354@gmail.com" and password "abcd123"

  @New
  Scenario Outline: Purchase product(s) added in cart
    Given User has added product "<productName>" and quantity <productQty> under category "<productType>" to cart
    When User clicks on Place Order button
    And User enters name in Name field "Varun Goyal"
    And User enters country in Country field "India"
    And User enters city in City field "Chandigarh"
    And User enters card details in Credit Card field "1234567812345678"
    And User enters month in Month field "09"
    And User enters year in Year field "28"
    And User clicks on Purchase button
    Then validate that order ID is generated
    And User clicks on Logout button

    Examples: 
      | productType | productName      | productQty |
      | Laptops     | Sony vaio i5     |          2 |
      | Laptops     | Sony vaio i7     |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
