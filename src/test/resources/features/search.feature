@Search
Feature: Product Search Functionality
  As a customer
  I want to search for products
  So that I can find items I want to purchase

  Background:
    Given I am on the shopping website

  @Valid @Smoke
  Scenario: Successfully search for a product
    When I search for "Laptop"
    Then I should see search results
    And I should see at least 1 product in the results

  @Invalid
  Scenario: Search with empty query
    When I search for ""
    Then I should see a no results message
    And the search should return no products

  @Invalid
  Scenario: Search with special characters only
    When I search for "@#$%^&*"
    Then I should see a no results message
    Or I should see an error message about invalid search

  @Valid
  Scenario: Search for a specific product category
    When I search for "Electronics"
    Then I should see search results
    And I should see products in the results

  @Invalid
  Scenario: Search for non-existent product
    When I search for "XYZ123NonExistentProduct999"
    Then I should see a no results message
    And the search should return no products