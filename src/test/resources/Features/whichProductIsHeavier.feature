Feature: user can check which product is heavier
  Scenario Outline:
    Given user is on homepage of demostore
    Then user chooses bestsellers from hot deals submenu
    And user chooses <category> category and adds body oils to compare them
    Then user can compare products by weight

    Examples:
    |category|
    |Beauty & Health|



