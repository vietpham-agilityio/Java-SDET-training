Feature: Search by keyword

  @search
  Scenario: Searching for 'BDD'
    Given user is researching articles on the DEV community
    When user looks up "BDD"
    Then user should see articles have title match with "BDD"
