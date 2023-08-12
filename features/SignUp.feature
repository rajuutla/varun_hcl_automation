
Feature: Sign up feature
  I want to be able to signup on the application
  
  Background: 
  	Given User is on the the home page
  	And Initialize the elements on the SignUp page
	
	@Smoke
  Scenario: Signup with new user
    When User clicks on Signup link
    And User enters the new email and password on signup popup
    And User clicks on Signup button on the signup popup
    Then validate that signup is successful
   
  @Negative 
  Scenario: Signup with existing user
    When User clicks on Signup link
    And User enters the existing email "<username>" and existing password "<password>" on signup popup
    And User clicks on Signup button on the signup popup
    Then validate that signup is unsuccessful
    
  Examples: 
  	| username 							| password  |
   	| username354@gmail.com | abcd123 	|