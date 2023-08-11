Feature: Sign In feature
  I want to be able to Sign in the application
  
  Background: 
  	Given User is on the the home page
  	And Initialize the elements on the SignIn page
	
	@Smoke
  Scenario Outline: Sign in successful
    When User clicks on Signin link
    And User enters the email "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validate that Signin status
    And User logs out of the application
    
   Examples: 
  	| username 							| password  |
   	| username354@gmail.com | abcd123 	|
    
  Scenario Outline: Sign in invalid credentials
    Given Initialize the elements on the SignIn page
    When User clicks on Signin link
    And User enters the email "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validates Signin status
    And User logs out of the application
    
   Examples: 
  	| username 							| password  |
   	| username@gmail.com | abcd123 	|
    