#Author: ps242215@gmail.com
@Course_Selection
Feature: Selecting a course
  @Course_Display
  Scenario: Course list displayed
    Given user clicks on Courses tab
    When user selects any course
    Then user redirected to course page
	@Course_Purchase
	Scenario: User purchases a course
		When user is on selected course page #title match
		Then user clicks on Get TestBook Pass