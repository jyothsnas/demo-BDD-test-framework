@smokeTest
Feature: User journey for Mobile phones search
  As a User
  I want to be able to search for Electronics and computers
  So that I can see the results for the required products

  Scenario Outline: List all the Samsung phones with the User given specifications
    Given User landed on the HomePage
    When User selects "<Category>" from the Main menu
    And selects "<SubCategory>"
    And Selects the Mobile phones "<Brand>"
    Then User should see the specifications for "Samsung" mobiles

    Examples:
    |Category                |SubCategory          |Brand    |
    |Electronics & Computers |Phones & Accessories |Samsung  |