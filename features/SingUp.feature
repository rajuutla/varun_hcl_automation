Feature: Sign up feature
  I want to be able to signup on the application

  Scenario: Signup the new user
    Given User is on the the home page
    When User click on Signup link
    And User enter the new email and password on signup popup
    And User click on Signup button on the signup popup
    Then validate that signup is successful
