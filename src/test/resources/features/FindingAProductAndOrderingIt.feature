Feature: Searching for the product and next ordering it

  Scenario:
    Given user has an open homepage of the store and searches for watch
    When user see all the search results and selects the cheapest watch
    Then user orders the watch

  Scenario:
    Given user has an open home page of DemoStore
    When user puts the name of the product in the search output and presses search button
    Then user chooses the product he needs from the products that was found

  Scenario:
    Given user has an open page of the Store
    When user puts the name of the product in the search field and presses search button
    And user choose the product from the list of products and makes an order
    Then user provides his email to the email input
    Then user provides his personal information for the delivery and chooses the delivery method