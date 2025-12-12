package com.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "cart-item")
    private List<WebElement> cartItems;

    @FindBy(id = "emptyCartMessage")
    private WebElement emptyCartMessage;

    @FindBy(id = "totalPrice")
    private WebElement totalPrice;

    @FindBy(id = "checkoutButton")
    private WebElement checkoutButton;

    @FindBy(className = "remove-item")
    private List<WebElement> removeButtons;

    @FindBy(className = "quantity-input")
    private List<WebElement> quantityInputs;

    @FindBy(id = "continueShoppingButton")
    private WebElement continueShoppingButton;

    @FindBy(id = "cartTitle")
    private WebElement cartTitle;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        try {
            waitForElementToBeVisible(cartTitle);
            return cartItems.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isCartEmpty() {
        return isElementDisplayed(emptyCartMessage);
    }

    public String getEmptyCartMessage() {
        return getElementText(emptyCartMessage);
    }

    public String getTotalPrice() {
        return getElementText(totalPrice);
    }

    public void clickCheckout() {
        clickElement(checkoutButton);
    }

    public void removeFirstItem() {
        if (!removeButtons.isEmpty()) {
            clickElement(removeButtons.get(0));
        }
    }

    public void updateQuantity(int index, String quantity) {
        if (index < quantityInputs.size()) {
            enterText(quantityInputs.get(index), quantity);
        }
    }

    public void continueShopping() {
        clickElement(continueShoppingButton);
    }

    public boolean isCheckoutButtonEnabled() {
        try {
            return checkoutButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}