package com.exam.steps;

import com.exam.pages.CheckoutPage;
import com.exam.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutSteps {
    private WebDriver driver = DriverManager.getDriver();
    private CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("I fill in the checkout form with valid details")
    public void i_fill_in_the_checkout_form_with_valid_details() {
        checkoutPage.fillCompleteForm(
                "John",
                "Doe",
                "john.doe@example.com",
                "1234567890",
                "123 Main Street",
                "New York",
                "10001",
                "4111111111111111"
        );
        System.out.println("✓ Filled checkout form with valid details");
    }

    @When("I fill in the form with first name {string}")
    public void i_fill_in_the_form_with_first_name(String firstName) {
        checkoutPage.fillFirstName(firstName);
        System.out.println("✓ Filled first name: " + firstName);
    }

    @When("I fill in the form with last name {string}")
    public void i_fill_in_the_form_with_last_name(String lastName) {
        checkoutPage.fillLastName(lastName);
        System.out.println("✓ Filled last name: " + lastName);
    }

    @When("I fill in the form with email {string}")
    public void i_fill_in_the_form_with_email(String email) {
        checkoutPage.fillEmail(email);
        System.out.println("✓ Filled email: " + email);
    }

    @When("I fill in the form with phone {string}")
    public void i_fill_in_the_form_with_phone(String phone) {
        checkoutPage.fillPhone(phone);
        System.out.println("✓ Filled phone: " + phone);
    }

    @When("I leave the email field empty")
    public void i_leave_the_email_field_empty() {
        checkoutPage.fillEmail("");
        System.out.println("✓ Left email field empty");
    }

    @When("I leave required fields empty")
    public void i_leave_required_fields_empty() {
        // Fill only some fields, leave others empty
        checkoutPage.fillFirstName("John");
        checkoutPage.fillLastName("");
        checkoutPage.fillEmail("");
        System.out.println("✓ Left required fields empty");
    }

    @When("I submit the order")
    public void i_submit_the_order() {
        checkoutPage.submitOrder();
        System.out.println("✓ Submitted order");
    }

    @Then("I should see an order confirmation message")
    public void i_should_see_an_order_confirmation_message() {
        assertTrue(checkoutPage.isSuccessMessageDisplayed(),
                "Order confirmation message should be displayed");
        String message = checkoutPage.getSuccessMessage();
        assertTrue(message.contains("success") || message.contains("confirmed"),
                "Should show success message");
        System.out.println("✓ Order confirmation: " + message);
    }

    @Then("I should see an error about invalid email format")
    public void i_should_see_an_error_about_invalid_email_format() {
        assertTrue(checkoutPage.isErrorMessageDisplayed(),
                "Email format error should be displayed");
        String error = checkoutPage.getEmailError();
        assertTrue(error.contains("valid") || error.contains("format") || error.contains("email"),
                "Should show email format error");
        System.out.println("✓ Email format error: " + error);
    }

    @Then("I should see an error about required fields")
    public void i_should_see_an_error_about_required_fields() {
        assertTrue(checkoutPage.isRequiredFieldErrorDisplayed(),
                "Required field error should be displayed");
        System.out.println("✓ Required fields error displayed");
    }

    @Then("the order should not be submitted")
    public void the_order_should_not_be_submitted() {
        assertFalse(checkoutPage.isSuccessMessageDisplayed(),
                "Order should not be submitted");
        System.out.println("✓ Order not submitted as expected");
    }
}