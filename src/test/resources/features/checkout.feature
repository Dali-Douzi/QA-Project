@Checkout
Feature: Checkout Process
  As a customer
  I want to complete the checkout process
  So that I can purchase my items

  Background:
    Given I am on the shopping website
    And I have added a product to the cart
    And I proceed to checkout

  @Valid @Critical
  Scenario: Complete checkout with valid information
    When I fill in the checkout form with valid details
    And I submit the order
    Then I should see an order confirmation message

  @Invalid
  Scenario: Submit checkout form with invalid email
    When I fill in the form with first name "John"
    And I fill in the form with last name "Doe"
    And I fill in the form with email "invalid-email"
    And I submit the order
    Then I should see an error about invalid email format
    And the order should not be submitted

  @Invalid
  Scenario: Submit checkout form with missing required fields
    When I leave required fields empty
    And I submit the order
    Then I should see an error about required fields
    And the order should not be submitted

  @Invalid
  Scenario: Submit checkout with empty email
    When I fill in the form with first name "John"
    And I fill in the form with last name "Doe"
    And I leave the email field empty
    And I submit the order
    Then I should see an error about required fields

  @Valid
  Scenario: Checkout with multiple items
    When I fill in the checkout form with valid details
    And I submit the order
    Then I should see an order confirmation message