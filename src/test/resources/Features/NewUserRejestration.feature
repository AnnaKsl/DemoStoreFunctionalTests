Feature: registration of a new user
  Scenario Outline:
    Given user is on a home page of the demostore presses the sign in/up button and then create new account button
    When user provides his <email>, <password> and confirms password
    Then user adds new delivery address and provides <firstname>,<lastname>,<city>,<country>,<address> and <zipcode>


    Examples:
    |email|password|firstname|lastname|city|country|address|zipcode|
    |12345@gmail.com|1234567|Masha|Bers|Minsk|Belarus|Panchenko str.|220021|