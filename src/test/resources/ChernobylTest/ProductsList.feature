Feature: Products List
  Check if user sees products on index page

  Scenario: product check
    Given I have Products and a default Product Category in the application
    When I open the root url
    Then ensure I can see a list of Products
    Then ensure that the following details are displayed: product title, description, image, price
    And sopd le az almat

