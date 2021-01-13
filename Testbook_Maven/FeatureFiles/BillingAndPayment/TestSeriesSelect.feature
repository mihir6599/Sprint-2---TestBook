#Author: ps242215@gmail.com
@TestSeries_Selection
Feature: Selecting test series
  @Series_Display
  Scenario: Series list displayed
    Given user clicks on Test series tab
    When user views any test series		#view button click
    Then user redirected to relevant series page
	@Series_Purchase
	Scenario: 
		When user is on selected series page
		Then user clicks on unlock now button
	@FreeSeriesDisplay
	Scenario:
		When user clicks on Test series tab
		Then user is diplayed free test series list
		