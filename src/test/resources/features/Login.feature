@login
Feature: Test login feature of Orange HRM application

  Scenario Outline: Verify admin login successfully to the application
    Given user launches the application with "https://www.google.com/"
    And enters username "<username>" and password "<password>"
    When signs in the application
    Then sees successful login to the application

    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline: Verify external user login successfully to the application
    Given user launches the application with "https://www.bing.com/"
    And enters username "<username>" and password "<password>"
    When signs in the application
    Then sees successful login to the application

    Examples:
      | username | password |
      | Test    | test123 |