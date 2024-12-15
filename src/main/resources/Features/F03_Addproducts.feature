@allure.label.epic:Web
Feature: Purchase Products

  Scenario: Add and purchase two products
    Given the user is logged in
    When user click on laptobs from PLP
    And user add "Sony vaio i5" and "Dell i7 8gb"
    Then both products "Sony vaio i5" and "Dell i7 8gb" should be visible in the cart
    And the total amount should be calculated correctly
    When the user proceeds to checkout
    And the user fills in checkout details
    And confirms the purchase
    Then a success message should be displayed
