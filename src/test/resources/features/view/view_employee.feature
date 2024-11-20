Feature: View list employee on Home page

  Background: User on Home page
    Given the user is on Home page

  @view-employee
  Scenario: Verify default display ten employees per page
    When the user click on Expand all button
    Then verify default display ten employees per page

  @select-employee
  Scenario Outline: Verify user is able to select number of employees display per page
    And the user click on the Rows per page dropdown
    And the user see list options dropdown
    When the user select "<number_of_rows>" from the list options dropdown
    Then verify display "<number_of_rows>" of employees per page

      Examples:
        | number_of_rows |
        | 5              |
        | 10             |
        | 15             |
        | 20             |
        | 25             |
        | 30             |
        | 50             |
        | 100            |
