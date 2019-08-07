Feature: Checkout the items from the Shopping Cart

  Scenario: Checkout the items from the Shopping Cart, so that I can order the Products

  Given I have a Shopping Cart review page
  When I click on the "Checkout" button
  Then ensure it asks the following data from the User: Name, Email, Phone number, Billing Address (Country, City, Zipcode, Address), Shipping Address (Country, City, Zipcode, Address)
    And it stores the validated data to the Order
    And it redirects to the Payment page