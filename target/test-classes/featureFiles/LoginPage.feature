
Feature: Verify user is able to go to admin login page.

Admin should be able to go to admin portal 
and should be able to login to the admin portal

Background: 
	Given User is on the swopper admin login page
	
  @SmokeTest
  Scenario Outline: Verify admin is able to successfully login with the valid credentials
    Given I have entered a valid "<username>" and "<password>"
    When I clicked on login button
    Then I should be logged in successfully
    
  Examples: 
      | username  | password |
      | fenger@swopper.ai     |     admin@123    |

  @SmokeTest
  Scenario Outline: Verify admin is not able to login if the credentials are not correct
    Given I have entered a valid "<username>" and "<password>"
    When I clicked on login button
    Then I should get error toast

    Examples: 
      | username  | password |
      | amit@ymirlabs.com     |     ymir@123    | 
     
      
 
      
