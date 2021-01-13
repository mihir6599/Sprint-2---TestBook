#Author: mihir.rahate@gmail.com
@Email_Login
Feature: Login using Email

	@Testbook
	Scenario: Testbook Page
		Given user is on testbook site
		And user clicks on login button
	
	@Valid_Email
	Scenario Outline: Valid email login
		When user enters valid <email> valid <password> clicks login
		Then user is  redirected to homepage
		And user clicks on get pass and selects a pass
		And selects card payment
		Examples:
		| email | password |
		| mihir.rahate@gmail.com | mihir123 |
		
		
	@Live_Classes
	Scenario Outline: Valid email login
		When user enters valid <email> valid <password> clicks login
		Then user is  redirected to homepage
		And user clicks on live classes, selects a live class
		Then user is  redirected to live videos page
		And user clicks on get pass and selects a pass
		And selects card payment, enters card detail
		Examples:
		| email | password |
		| mihir.rahate@gmail.com | mihir123 |