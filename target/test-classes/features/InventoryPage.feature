Feature: Test Inventory page functions

  Background: 
    Given User login with valid user

  Scenario: Verify Inventory page Title
    When User capture the Title of Inventory Page
    Then Inventory page title should contains "Labs"

  Scenario: User able to add Product to cart
    When User Click on product name as "Sauce Labs Bolt T-Shirt"
    And Click on Add to cart button
    Then Product should be added to Cart is "Sauce Labs Bolt T-Shirt Aseem"
