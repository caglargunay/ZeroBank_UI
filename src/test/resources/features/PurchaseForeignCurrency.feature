@Purchase
Feature: Purchase Foreign Currency

  Background:
    Given user is on the login page
    When user enters valid credentials
    And user clicks sing in button
    Then user should be logged in
    When user clicks "Online Banking" link
    And user clicks "Pay Bills" link
    And user clicks "Purchase foreign currency" link


  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed
