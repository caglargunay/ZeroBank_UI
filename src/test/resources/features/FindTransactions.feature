Feature: Find Transactions in Account Activity

  Background:
    Given user is on the login page
    When user enters valid credentials
    And user clicks sing in button
    Then user should be logged in
    When user clicks "Online Banking" link
    When user clicks "Account Activity" link
    When user clicks "Find Transactions" link

  Scenario: Search date range

    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to  "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to  "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  Scenario Outline: Search description

    When the user enters description "<keyword>"
    And clicks search
    Then results table should only show descriptions containing "<contain>"
    But results table should not show descriptions containing "<notContain>"

    Examples:
      | keyword | contain | notContain |
      | ONLINE  | ONLINE  | OFFICE     |
      | OFFICE  | OFFICE  | ONLINE     |
      | online  | ONLINE  | online     |


  @wip
  Scenario: Type

    When clicks search
    Then results table should show at least one result under "Deposit"
    Then results table should show at least one result under "Withdrawal"
    When user selects type "Deposit"
    And clicks search
    Then results table should show at least one result under "Deposit"
    But results table should show no result under "Withdrawal"
    When user selects type "Withdrawal"
    And clicks search
    Then results table should show at least one result under "Withdrawal"
    But results table should show no result under "Deposit"
