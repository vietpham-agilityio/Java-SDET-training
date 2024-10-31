Feature:  Authentication on login page

  Scenario: Verify user is able to login successfully
    Given the user is on login page
    And the user enters a valid username and password on page login
    When click on the button login on page login
    Then verify user is able to login successfully