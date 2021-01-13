#Author: ps242215@gmail.com
@Email_Login
Feature: Login using Email
	@Testbook_Page
	Scenario: Testbook Page
		Given user is on testbook site
	@Valid_Email_Login
	Scenario Outline: Valid email login
		Given user clicks on login button
		When user enters valid <email> valid <password> clicks login
		Then user is  redirected to homepage
		Examples:
		| email | password |
		| ps242215@gmail.com | 12345 |
	@Invalid_Email_Login 
	Scenario Outline: Invalid email login
		Given user clicks on login button
		When enters invalid <email>, clicks next
		Then user is displayed invalid email error message
		Examples:
		| email |
		| ps242215@ |
		| ps_234324 |
		#email / password parameterized
	@Incorrect_Password
	Scenario Outline: Incorrect password login
		Given user clicks on login button
		When enters valid <email> invalid <password> clicks login
		Then user is displayed error message
		Examples:
		| email | password |
		| ps242215@gmail.com | dnsdew |
	@No_Email_Login
	Scenario: Login without email
		Given user clicks on login button
		When clicks on next button
		Then user is displayed email required message
	@No_Password_Login
	Scenario Outline: Login without password
		Given user clicks on login button
		When enters valid <email> clicks next login
		Then user is displayed password blank message
		Examples:
		| email |
		| ps242215@gmail.com |


