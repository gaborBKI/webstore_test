Feature: Review cart
  Verify that after an item had been added to the cart its quantity and price is displayed on the review page. Ensure that the correct total price of all items in the cart is displayed.

  Scenario Outline: There is at least 1 item in my cart.
    Given I have a Shopping Cart with items in it
    When I click on the Shopping cart menu item in the Page header
    Then ensure it displays the items (LineItems) with the following data "<Name of the Product>", "<Quantity>". "<Unit Price>"
    And ensure it displays the total price of all the items in the cart

    Examples:
      | Name of the Product  |Quantity  |Unit Price  |
      | Fire Engine           | 1       | 9990.0     |