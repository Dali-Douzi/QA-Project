@Filter
Feature: Product Filtering and Sorting
  As a customer
  I want to filter and sort products
  So that I can find items that match my preferences

  Background:
    Given I am on the shopping website
    And I search for "Products"

  @Valid
  Scenario: Filter products by category
    When I filter by category "Electronics"
    Then I should see only "Electronics" products
    And I should see products in the results

  @Valid
  Scenario: Sort products by price
    When I sort by "Price: Low to High"
    Then the results should be sorted by price
    And I should see products in the correct order

  @Invalid
  Scenario: Apply invalid price range filter
    When I apply an invalid price filter
    Then I should see an error about invalid price range
    Or I should see no results

  @Invalid
  Scenario: Filter by category with no products
    When I filter by a category with no products
    Then I should see a no results message
    And the search should return no products

  @Valid
  Scenario: Apply price range filter
    When I apply a price filter from "100" to "500"
    Then all displayed products should be within the price range
    And I should see products in the results