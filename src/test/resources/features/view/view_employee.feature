Feature: View list employee on Home page

  Background: User on Home page
    Given the user is on Home page

  @view-employee
  Scenario: Verify default display ten employees per page
    When the user click on Expand all button
    Then verify default display ten employees per page