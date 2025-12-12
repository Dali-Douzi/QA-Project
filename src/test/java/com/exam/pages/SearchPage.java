package com.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(id = "searchResults")
    private WebElement searchResults;

    @FindBy(className = "product-item")
    private List<WebElement> productItems;

    @FindBy(id = "noResultsMessage")
    private WebElement noResultsMessage;

    @FindBy(id = "searchQuery")
    private WebElement searchQuery;

    @FindBy(id = "resultCount")
    private WebElement resultCount;

    @FindBy(id = "filterCategory")
    private WebElement filterCategory;

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public int getProductCount() {
        waitForElementToBeVisible(searchResults);
        return productItems.size();
    }

    public boolean isNoResultsMessageDisplayed() {
        return isElementDisplayed(noResultsMessage);
    }

    public String getNoResultsMessage() {
        return getElementText(noResultsMessage);
    }

    public String getSearchQuery() {
        return getElementText(searchQuery);
    }

    public String getResultCount() {
        return getElementText(resultCount);
    }

    public void selectCategory(String category) {
        clickElement(filterCategory);
        // Additional logic for dropdown selection
    }

    public void sortBy(String sortOption) {
        clickElement(sortDropdown);
        // Additional logic for dropdown selection
    }

    public boolean areResultsDisplayed() {
        return isElementDisplayed(searchResults);
    }
}