package com.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(className = "product-card")
    private WebElement firstProduct;

    @FindBy(id = "cartIcon")
    private WebElement cartIcon;

    @FindBy(id = "cartCount")
    private WebElement cartCount;

    @FindBy(id = "welcomeMessage")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String productName) {
        enterText(searchInput, productName);
        clickElement(searchButton);
    }

    public void clickFirstProduct() {
        clickElement(firstProduct);
    }

    public void goToCart() {
        clickElement(cartIcon);
    }

    public String getCartCount() {
        return getElementText(cartCount);
    }

    public boolean isWelcomeMessageDisplayed() {
        return isElementDisplayed(welcomeMessage);
    }

    public String getWelcomeMessage() {
        return getElementText(welcomeMessage);
    }
}