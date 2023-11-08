@us1
Feature: Navigating to specific accounts in Accounts Activity

  Background: user logins

    Given user is on the login page
    When user enters valid credentials
    And user clicks sing in button
    Then user should be logged in

  Scenario Outline: Savings account redirect
    When user clicks "Online Banking" link
    And user clicks "Account Summary" link
    When user clicks "<Links>" link
    Then the Account Activity page should be displayed
    And Account drop down should have "<Links>" selected

    Examples:
      | Links       |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |


