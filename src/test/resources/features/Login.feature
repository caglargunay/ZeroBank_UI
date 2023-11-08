@Login
Feature: Login functionality

  Scenario: User should be able to log in with valid credentials
    Given user is on the login page
    When user enters valid credentials
    And user clicks sing in button
    Then user should be logged in

  @AC2
  Scenario Outline: User should see error message in negative scenarios
    Given user is on the login page
    When user enters "<username>" as username and  "<password>" as password
    And user clicks sing in button

    And user should see error message "Login and/or password are wrong."

    Examples:
      | username  | password      |
      | usernae   | password      |
      | username  |               |
      |           | password      |
      | USERname  | PASSword      |
      | username  | Password      |
      | Userwrong | passwordwrong |
      |           |               |


