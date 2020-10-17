Feature: user can find a product he wants and order it
  Scenario:
    Given user has an open page of the Store
    When user puts the name of the product in the search field and presses search button
    And user can choose the product he wants form the list of products and make an order
    Then user provides his email to the email input
    Then user provides his personal information for the delivery and chooses the delivery method