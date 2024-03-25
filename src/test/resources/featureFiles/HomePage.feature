Feature: Verify admin is able to view the other options.

Admin should be able to view Home, Notifictions, Filter tabs 
from the admin homepage and should able to able to view logout option.

Background: Admin should login to admin portal
	Given Admin should be able to logged in to the application
	| username       | password|
 |fenger@swopper.ai|admin@123|

	Scenario: Verify the title of the homepage
	Given Admin is on the homepage where page title is "Swopper"