Feature: Sign In feature
  I want to be able to Sign in the application
  
  Background: 
  	Given User is on the the home page
  	
	@Smoke
  Scenario Outline: Sign in successful
    Given Initialize the elements on the SignIn page
    When User clicks on Signin link
    And User enters the email "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validate that Signin is successful
    
   Examples: 
  	| username 							| password  |
   	| username354@gmail.com | abcd123 	|
    