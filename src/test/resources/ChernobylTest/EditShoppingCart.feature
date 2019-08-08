Feature: Edit Shopping Cart
  Ensure that it is possible to add and remove items from the shopping cart.

  Scenario: Adding and removing items from cart.

    Given I have a Shopping Cart review page
    And the LineItems are displayed in a form
    And the quantities are displayed in input fields
    When I change the quantity of an item
    Then ensure it stores the new quantity of the LineItem
    When I change the quantity to 0
    Then ensure it removes the LineItem from the cart