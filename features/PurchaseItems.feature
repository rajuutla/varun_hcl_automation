Feature: Add product(s) to cart feature
  User is able to add product to cart

  Background: 
    Given Initialize the elements on the PurchaseItems page
    And User has Login into the application with username "username354@gmail.com" and password "abcd123"

  @Smoke
  Scenario Outline: Add product(s) to cart
    When User clicks on product type link "<productType>"
    And User searches for a product "<productName>"
    And User adds multiple quantities <productQty> of above product to cart
    And User navigates to cart
    Then validate products in a cart
    And User clicks on Logout button

    Examples: 
      | productType | productName  | productQty |
      | Laptops     | Sony vaio i5 |          2 |

  @Smoke
  Scenario Outline: Validate items in cart and Cart Value
    Given User clears the cart
    When User adds the following product "<productName1>" and quantity <productQty1> under category "<productType1>" to cart
    And User adds the following product "<productName2>" and quantity <productQty2> under category "<productType2>" to cart
    And User adds the following product "<productName3>" and quantity <productQty3> under category "<productType3>" to cart
    But User navigates to cart
    Then validate that selected products are added to cart
    And User clears the cart
    And User clicks on Logout button

    Examples: 
      | productType1 | productName1 | productQty1 | productType2 | productName2  | productQty2 | productType3 | productName3     | productQty3 |
      | Laptops      | Sony vaio i5 |           2 | Phones       | Iphone 6 32gb |           3 | Monitors     | Apple monitor 24 |           1 |

  @Smoke
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
