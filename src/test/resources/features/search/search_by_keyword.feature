Feature: Search articles by keyword

  @search
  Scenario: Verify user is able to see list article on dropdown result when search on home page
    Given the user is on the DEV community page
    When enters "BDD" inside the input search on home page
    Then verify user is able to see list article have title match "BDD" on dropdown result
