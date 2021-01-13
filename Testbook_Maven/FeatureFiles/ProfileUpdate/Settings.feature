#Author: ps242215@gmail.com
@Update_Settings
Feature: Update profile details
  @Settings_Page
  Scenario: User tries to update profile 
    Given user is homepage
    When user clicks on dropdown settings
    Then user redirected to settings page 
  @Profile_Update
  Scenario: User tries to Update profile pic
    Given user on settings page
    When user clicks on change pic  
    Then updates valid file user profile pic should be updated
	@Details_Update
  Scenario Outline: User tries to Update profile details
    Given user on settings page
    When user gives <education_type> dob category <pincode> language clicks save profile 
    Then user profile should be updated
    Examples:
    | education_type | pincode |
    | engineering | 302020 |

	