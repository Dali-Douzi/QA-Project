@Cart
Feature: Shopping Cart Management
  As a customer
  I want to manage items in my shopping cart
  So that I can review my purchases before checkout

  Background:
    Given I am on the shopping website

  @Valid @Smoke
  Scenario: Add product to cart and view it
    Given I have added a product to the cart
    When I view my shopping cart
    Then I should see 1 item in the cart
    And the total price should be displayed

  @Valid
  Scenario: Remove item from cart
    Given I have added a product to the cart
    When I view my shopping cart
    And I remove the item from cart
    Then the cart should be empty
    And I should see an empty cart message

  @Invalid
  Scenario: Add negative quantity to cart
    Given I have added a product to the cart
    When I view my shopping cart
    And I update the quantity to "-5"
    Then I should see an error about invalid quantity

  @Invalid
  Scenario: Proceed to checkout with empty cart
    When I go to the cart page
    Then the cart should be empty
    And the checkout button should be disabled

  @Valid
  Scenario: Update item quantity in cart
    Given I have added a product to the cart
    When I view my shopping cart
    And I update the quantity to "3"
    Then I should see 1 item in the cart
    And the total price should be updated