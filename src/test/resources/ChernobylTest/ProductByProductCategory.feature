Feature: Filter Product By Product Category
  Check if the customer can filter out products by product category


  Scenario Outline: Filter By Category
    Given I have Products and Product Categories listed on the index page
    When I I click on a Category's "<title>"
    Then ensure it displays the "<number of Products>" only in the selected Category
    Examples:
      | title                   | number of Products  |
      | Select Product Category |         21           |
      | Vehicles                |         5           |
      | Relics                  |         5           |
      | Protector Suits         |         5           |
      | Medicines               |         2           |
      | HR                      |         4           |