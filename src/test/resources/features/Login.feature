Feature: Verify functionality of Login Page

  Background: 
    Given User launch the Url "https://www.saucedemo.com/"

  Scenario: Verify title of Login Page
    When User get the title of login page
    Then title should be match with "Swag"

  Scenario Outline: Verify with Valid credentials
    When User Enter "<Username>" and "<Password>"
    And User Enter Login button
    Then User land on Inventory page and Inventory Page url contains "inventory"

    Examples: 
      | Username      | Password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario: Verify with In Invalid credentials
    When User Enter Username "locked_out_user"
    And User Enter Password "secret_sauce"
    Then System show warning message
