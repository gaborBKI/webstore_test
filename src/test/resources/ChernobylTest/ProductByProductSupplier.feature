Feature: Product filtering by Product Supplier
  Check if user can filter product by product supplier

  Scenario Outline: Filtering by Supplier
Given I have Products and Suppliers listed on the index page
When I I click on a "<Supplier's name>"
Then ensure it displays the "<number of Products>" only for the selected Supplier

    Examples:
      | Supplier's name            |  number of Products  |
      | Select Supplier            |  21                  |
      | Non Infected               |  16                  |
      | Infected                   |  5                   |