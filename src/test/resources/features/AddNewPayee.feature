@wipi
Feature: Add new payee under pay bills

  Background:
    Given user is on the login page
    When user enters valid credentials
    And user clicks sing in button
    Then user should be logged in
    When user clicks "Online Banking" link
    And user clicks "Pay Bills" link
    And user clicks "Add New Payee" link

  Scenario: Add a new payee

    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |

    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed

