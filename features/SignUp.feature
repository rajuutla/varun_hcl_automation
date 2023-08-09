
Feature: Sign up feature
  I want to be able to signup on the application
  
  Background: 
  	Given User is on the the home page

  Scenario: Signup the new user
  	Given Initialize the elements on the SignUp page
    When User clicks on Signup link
    And User enters the new email and password on signup popup
    And User clicks on Signup button on the signup popup
    Then validates that signup is successful
