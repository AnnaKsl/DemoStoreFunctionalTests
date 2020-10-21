Feature: registration of a new user

  Scenario Outline:
    Given i press create new account button
    When user provides his <email>, <password> and confirms password
    And  user adds new delivery address and following details
      | firstname | lastname | city  | country | address        | zipcode |
      | Masha     | Bers     | Minsk | Belarus | Panchenko Str. | 220021  |
    Then new address is added with proper data
      | address        | country | city  | zipcode |
      | Panchenko Str. | Belarus | Minsk | 220021  |

    Examples:
      | email           | password |
      | 12345@gmail.com | 1234567  |
