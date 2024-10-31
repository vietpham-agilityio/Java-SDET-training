Feature: Search articles by keyword

  @search
  Scenario: Searching articles by keyword entered in the search input
    Given the user is on the DEV community page
    When the user enters "String" inside the search input
    Then the user should see a list of articles with titles that match the entered "String"
