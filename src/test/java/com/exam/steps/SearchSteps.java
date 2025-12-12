package com.exam.steps;

import com.exam.pages.HomePage;
import com.exam.pages.SearchPage;
import com.exam.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SearchSteps {
    private WebDriver driver = DriverManager.getDriver();
    private HomePage homePage;
    private SearchPage searchPage;

    @Given("I am on the shopping website")
    public void i_am_on_the_shopping_website() {
        String projectPath = System.getProperty("user.dir");
        String url = "file://" + projectPath + "/src/main/resources/shopping-app.html";
        DriverManager.navigateTo(url);
        homePage = new HomePage(driver);
        System.out.println("✓ Navigated to shopping website");
    }

    @When("I search for {string}")
    public void i_search_for(String productName) {
        homePage.searchForProduct(productName);
        searchPage = new SearchPage(driver);
        System.out.println("✓ Searched for: " + productName);
    }

    @Then("I should see search results")
    public void i_should_see_search_results() {
        assertTrue(searchPage.areResultsDisplayed(), "Search results should be displayed");
        assertTrue(searchPage.getProductCount() > 0, "Should have at least one product");
        System.out.println("✓ Search results displayed: " + searchPage.getProductCount() + " items");
    }

    @Then("I should see {int} product(s) in the results")
    public void i_should_see_products_in_the_results(Integer expectedCount) {
        int actualCount = searchPage.getProductCount();
        assertEquals(expectedCount.intValue(), actualCount,
                "Expected " + expectedCount + " products but found " + actualCount);
        System.out.println("✓ Verified product count: " + actualCount);
    }

    @Then("I should see a no results message")
    public void i_should_see_a_no_results_message() {
        assertTrue(searchPage.isNoResultsMessageDisplayed(), "No results message should be displayed");
        String message = searchPage.getNoResultsMessage();
        assertTrue(message.contains("No results") || message.contains("not found"),
                "Message should indicate no results");
        System.out.println("✓ No results message displayed: " + message);
    }

    @Then("I should see an error message about invalid search")
    public void i_should_see_an_error_message_about_invalid_search() {
        assertTrue(searchPage.isNoResultsMessageDisplayed(), "Error message should be displayed");
        System.out.println("✓ Invalid search error displayed");
    }

    @Then("the search should return no products")
    public void the_search_should_return_no_products() {
        assertEquals(0, searchPage.getProductCount(), "Should have zero products");
        System.out.println("✓ No products found as expected");
    }
}