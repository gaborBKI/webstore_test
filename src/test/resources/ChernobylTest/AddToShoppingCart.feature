Feature: Add to cart
  Ensure that after clicking on an item's add to cart button it gets put into the cart and its quantity is displayed on the page header.

  Scenario Outline: Webshop is open and is on the index page.
    Given I have a Product list
    And the Products have an "Add to cart" button
    When I click on the "Add to cart" button of the "<Product Name>" product
    Then ensure it creates a new Order for storing cart data of the User
    And ensure it creates a new LineItem with the quantity of 1 and price "<Product Price>"
    And ensure it stores this data on the server.
    And ensure it displays the number of cart items in the Page header.

    Examples:
      | Product Name            | Product Price |
      | Fire Engine             | 9990.0        |
      | Police Car              | 6690.0        |
      | Gas Mask                | 29.0          |