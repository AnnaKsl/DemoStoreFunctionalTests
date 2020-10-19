Feature: user can compare products via comparison list

  Scenario:
    Given I am on bestsellers page
    When i add 1st element to compare
    And i add second element to compare
    Then comparison list icon has 2 products
    And there are 2 elements in comparison table
    And these are the chosen products



