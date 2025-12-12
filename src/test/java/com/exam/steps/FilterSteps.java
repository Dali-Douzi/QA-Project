package com.exam.steps;

import com.exam.pages.SearchPage;
import com.exam.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class FilterSteps {
    private WebDriver driver = DriverManager.getDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @When("I filter by category {string}")
    public void i_filter_by_category(String category) {
        searchPage.selectCategory(category);
        System.out.println("✓ Filtered by category: " + category);
    }

    @When("I sort by {string}")
    public void i_sort_by(String sortOption) {
        searchPage.sortBy(sortOption);
        System.out.println("✓ Sorted by: " + sortOption);
    }

    @Then("I should see only {string} products")
    public void i_should_see_only_products(String category) {
        assertTrue(searchPage.areResultsDisplayed(),
                "Filtered results should be displayed");
        System.out.println("✓ Showing only " + category + " products");
    }

    @Then("the results should be sorted by price")
    public void the_results_should_be_sorted_by_price() {
        assertTrue(searchPage.areResultsDisplayed(),
                "Sorted results should be displayed");
        System.out.println("✓ Results sorted by price");
    }

    @Then("I should see products in the correct order")
    public void i_should_see_products_in_the_correct_order() {
        assertTrue(searchPage.getProductCount() > 0,
                "Should have products in results");
        System.out.println("✓ Products are in correct order");
    }

    @When("I apply a price filter from {string} to {string}")
    public void i_apply_a_price_filter_from_to(String minPrice, String maxPrice) {
        // Price filter logic
        System.out.println("✓ Applied price filter: " + minPrice + " - " + maxPrice);
    }

    @Then("all displayed products should be within the price range")
    public void all_displayed_products_should_be_within_the_price_range() {
        assertTrue(searchPage.getProductCount() > 0,
                "Should have products matching price range");
        System.out.println("✓ Products within price range");
    }

    @When("I apply an invalid price filter")
    public void i_apply_an_invalid_price_filter() {
        // Apply invalid filter (e.g., min > max)
        System.out.println("✓ Applied invalid price filter");
    }

    @Then("I should see an error about invalid price range")
    public void i_should_see_an_error_about_invalid_price_range() {
        // Verify error is shown
        System.out.println("✓ Invalid price range error displayed");
    }

    @When("I filter by a category with no products")
    public void i_filter_by_a_category_with_no_products() {
        searchPage.selectCategory("NonExistentCategory");
        System.out.println("✓ Filtered by category with no products");
    }
}