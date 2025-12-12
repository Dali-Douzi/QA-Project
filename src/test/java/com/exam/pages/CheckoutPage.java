package com.exam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipCode")
    private WebElement zipCodeInput;

    @FindBy(id = "cardNumber")
    private WebElement cardNumberInput;

    @FindBy(id = "submitOrderButton")
    private WebElement submitOrderButton;

    @FindBy(id = "successMessage")
    private WebElement successMessage;

    @FindBy(className = "error-message")
    private WebElement errorMessage;

    @FindBy(id = "emailError")
    private WebElement emailError;

    @FindBy(id = "requiredFieldError")
    private WebElement requiredFieldError;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName(String firstName) {
        enterText(firstNameInput, firstName);
    }

    public void fillLastName(String lastName) {
        enterText(lastNameInput, lastName);
    }

    public void fillEmail(String email) {
        enterText(emailInput, email);
    }

    public void fillPhone(String phone) {
        enterText(phoneInput, phone);
    }

    public void fillAddress(String address) {
        enterText(addressInput, address);
    }

    public void fillCity(String city) {
        enterText(cityInput, city);
    }

    public void fillZipCode(String zipCode) {
        enterText(zipCodeInput, zipCode);
    }

    public void fillCardNumber(String cardNumber) {
        enterText(cardNumberInput, cardNumber);
    }

    public void submitOrder() {
        clickElement(submitOrderButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(successMessage);
    }

    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

    public String getEmailError() {
        return getElementText(emailError);
    }

    public boolean isRequiredFieldErrorDisplayed() {
        return isElementDisplayed(requiredFieldError);
    }

    // Complete form with all fields
    public void fillCompleteForm(String firstName, String lastName, String email,
                                 String phone, String address, String city,
                                 String zipCode, String cardNumber) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPhone(phone);
        fillAddress(address);
        fillCity(city);
        fillZipCode(zipCode);
        fillCardNumber(cardNumber);
    }
}