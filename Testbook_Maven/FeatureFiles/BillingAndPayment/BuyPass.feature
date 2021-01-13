#Author: ps242215@gmail.com
@Purchase
Feature: Purchase Plan and Payment Method
  @BuyPassPlan
  Scenario: View Purchase Plan Payment Methods
    Given all plans are displayed
    When user clicks on Buy Pass 
    Then payment methods are displayed
  @Payment_methods_card
  Scenario Outline: user selects card payment
    Given user selects card payment
    When user enters <card_no> <exp_date> <holder_name> <cvv>	 
    Then clicks on pay
    Examples: 
      | card_no | cvv | exp_date | holder_name |
      | 1234567890123456 | 234 |   |  |
      | invalid |  |  |		|
	@Payment_methods_upi
  Scenario Outline: user selects upi payment
    Given user selects upi payment
    When user enters <upi_id>	 
    Then clicks on pay
    Examples: 
      | upi_id |
      | prachi@bank |
      | invalid |
      